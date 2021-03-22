package com.barrad.cinema.booking.cinemabookingapp.rest.movie;

import com.barrad.cinema.booking.cinemabookingapp.domain.movie.MovieCreateRequest;
import com.barrad.cinema.booking.cinemabookingapp.domain.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieRestService {
    private final MovieService movieService;
    private final MovieDTOConverter movieDTOConverter = new MovieDTOConverter();

    public void changeStatus(Long id, ChangeMovieStatusDTO changeMovieStatusDTO) {
    movieService.changeStatus(id, changeMovieStatusDTO.isActive());

    }

    public void addMovie(CreateMovieDTO createMovieDTO) {

        MovieCreateRequest movieCreateRequest = movieDTOConverter.convert(createMovieDTO);
                movieService.addMovie(movieCreateRequest);
    }

    public List<MovieDTO> getMovies(MovieSpecification movieSpecification) {

        return null;
    }
}
