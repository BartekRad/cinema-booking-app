package com.barrad.cinema.booking.cinemabookingapp.domain.show;

import com.barrad.cinema.booking.cinemabookingapp.persistance.model.HallEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.MovieEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.ShowEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.repo.HallRepository;
import com.barrad.cinema.booking.cinemabookingapp.persistance.repo.MovieRepository;
import com.barrad.cinema.booking.cinemabookingapp.persistance.repo.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowService {
    private final ShowRepository showRepository;
    private final ShowConverter showConverter = new ShowConverter();
    private final MovieRepository movieRepository;
    private final HallRepository hallRepository;


    public void addShows(ShowCreateBulkRequest showCreateBulkRequest) {
        MovieEntity movieEntity = getMovieById(showCreateBulkRequest.getMovieId());

        List<ShowEntity> showEntities = showCreateBulkRequest.getShows()
                .stream()
                .map(this::createShowEntity)
                .collect(Collectors.toList());

        showEntities.forEach(entity -> entity.setMovie(movieEntity));
        showRepository.saveAll(showEntities);
    }

    public List<Show> getShowsByHallId(Long id){
        HallEntity hallEntity = getHallEntity(id);
        return showRepository.findShowsByHall(hallEntity)
                .stream()
                .map(showConverter::convert)
                .collect(Collectors.toList());
    }

    private HallEntity getHallEntity(Long hallId){
        HallEntity hallEntity = hallRepository.findById(hallId)
                .orElseThrow(() -> new IllegalArgumentException("HAHA"));
                return hallEntity;
    }



    private ShowEntity createShowEntity(ShowCreateRequest showCreateRequest) {
        ShowEntity showEntity = showConverter.convert(showCreateRequest);
        showEntity.setHall(getHallEntity(showCreateRequest.getHallId()));
        return showEntity;
    }


    private MovieEntity getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("HAHA"));
    }
}
