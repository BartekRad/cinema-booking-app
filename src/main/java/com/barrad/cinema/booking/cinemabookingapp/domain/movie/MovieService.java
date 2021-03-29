package com.barrad.cinema.booking.cinemabookingapp.domain.movie;

import com.barrad.cinema.booking.cinemabookingapp.persistance.model.MovieEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.repo.MovieRepository;
import com.barrad.cinema.booking.cinemabookingapp.rest.movie.MovieSearchCriteria;
import com.barrad.cinema.booking.cinemabookingapp.rest.movie.SortOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieConverter movieConverter = new MovieConverter();

    public void addMovie(MovieCreateRequest movieCreateRequest) {
        movieRepository.save(movieConverter.convert(movieCreateRequest));

    }

    public void changeStatus(Long id, boolean isActive) {
        MovieEntity movieEntity = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("UHU"));
        movieEntity.setIsActive(isActive);
        movieRepository.save(movieEntity);
    }

    public List<Movie> getMovies(MovieSearchCriteria movieSearchCriteria) {
        PageRequest pageRequest = PageRequest.of(
                movieSearchCriteria.getPageNo(),
                movieSearchCriteria.getPageSize(),
                getSort(movieSearchCriteria));
        return movieRepository.findAll(new MovieSpecification(movieSearchCriteria), pageRequest)
                .stream()
                .map(movieEntity -> movieConverter.convert(movieEntity))
                .collect(Collectors.toList());
    }


    private Sort getSort(MovieSearchCriteria movieSearchCriteria) {
        if (SortOrder.DESC.equals(movieSearchCriteria.getSortOrder()))
            return Sort.by(movieSearchCriteria.getSortBy()).descending();
        return Sort.by(movieSearchCriteria.getSortBy()).ascending();
    }


}
