package com.barrad.cinema.booking.cinemabookingapp.rest.movie;

import com.barrad.cinema.booking.cinemabookingapp.domain.cinema.Cinema;
import com.barrad.cinema.booking.cinemabookingapp.domain.cinema.CinemaCreateRequest;
import com.barrad.cinema.booking.cinemabookingapp.domain.movie.Movie;
import com.barrad.cinema.booking.cinemabookingapp.domain.movie.MovieCreateRequest;
import com.barrad.cinema.booking.cinemabookingapp.rest.cinema.CinemaDTO;
import com.barrad.cinema.booking.cinemabookingapp.rest.cinema.CreateCinemaDTO;

public class MovieDTOConverter {

    MovieDTO convert(Movie movie){
        return MovieDTO.builder()
                .title(movie.getTitle())
                .ageLimit(movie.getAgeLimit())
                .director(movie.getDirector())
                .isActive(movie.getIsActive())
                .movieDuration(movie.getMovieDuration())
                .originalLanguage(movie.getOriginalLanguage())
                .productionCountry(movie.getProductionCountry())
                .productionYear(movie.getProductionYear())
                .build();
    }

    MovieCreateRequest convert(CreateMovieDTO createMovieDTO){
        return MovieCreateRequest.builder()
                .ageLimit(createMovieDTO.getAgeLimit())
                .director(createMovieDTO.getDirector())
                .movieDuration(createMovieDTO.getMovieDuration())
                .originalLanguage(createMovieDTO.getOriginalLanguage())
                .productionCountry(createMovieDTO.getProductionCountry())
                .productionYear(createMovieDTO.getProductionYear())
                .title(createMovieDTO.getTitle())
                .isActive(createMovieDTO.getIsActive())
                .build();
    }

}
