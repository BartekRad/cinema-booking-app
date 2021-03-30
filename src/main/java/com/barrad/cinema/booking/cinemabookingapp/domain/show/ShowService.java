package com.barrad.cinema.booking.cinemabookingapp.domain.show;

import com.barrad.cinema.booking.cinemabookingapp.persistance.model.HallEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.MovieEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.ShowEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.repo.HallRepository;
import com.barrad.cinema.booking.cinemabookingapp.persistance.repo.MovieRepository;
import com.barrad.cinema.booking.cinemabookingapp.persistance.repo.ShowRepository;
import com.barrad.cinema.booking.cinemabookingapp.rest.show.ShowTime;
import com.barrad.cinema.booking.cinemabookingapp.utils.exceptions.CinemaBookingBadRequestException;
import com.barrad.cinema.booking.cinemabookingapp.utils.exceptions.CinemaBookingNotFoundException;
import com.barrad.cinema.booking.cinemabookingapp.utils.exceptions.ExceptionCode;
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
        return hallRepository.findById(hallId)
                .orElseThrow(() -> new CinemaBookingNotFoundException(
                        String.format("Hall entity with id: %d", hallId ),
                        ExceptionCode.HALL_NOT_FOUND));
    }



    private ShowEntity createShowEntity(ShowCreateRequest showCreateRequest) {
        HallEntity hallEntity = getHallEntity(showCreateRequest.getHallId());
        validateHallIsAvailable(hallEntity, showCreateRequest.getShowTime());
        ShowEntity showEntity = showConverter.convert(showCreateRequest);
        showEntity.setHall(hallEntity);
        return showEntity;
    }


    private MovieEntity getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new CinemaBookingNotFoundException(
                        String.format("Movie with id = %d not found", id),
                        ExceptionCode.MOVIE_NOT_FOUND));
    }

    private void validateHallIsAvailable(HallEntity hallEntity, ShowTime showTime){
        List<ShowEntity> overlappingShows = showRepository.findOverlappingShows(
                showTime.getStartDate(),
                showTime.getEndDate(),
                hallEntity.getId());
        if (!overlappingShows.isEmpty() || !hallEntity.getIsAvailable()){
            throw new CinemaBookingBadRequestException(
                    String.format("Hall hallid = %d is not available for this range", hallEntity.getId()),
                    ExceptionCode.HALL_UNAVAILABLE);
        }
    }
}
