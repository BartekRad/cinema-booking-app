package com.barrad.cinema.booking.cinemabookingapp.domain.movie;

import com.barrad.cinema.booking.cinemabookingapp.persistance.model.MovieEntity;

import java.time.Duration;


public class MovieConverter {

    public Movie convert(MovieEntity movieEntity){
        return Movie.builder()
                .movieId(movieEntity.getId())
                .title(movieEntity.getTitle())
                .ageLimit(movieEntity.getAgeLimit())
                .movieDuration(Duration.ofSeconds(movieEntity.getDurationInSec()))
                .director(movieEntity.getDirector())
                .originalLanguage(movieEntity.getOriginalLanguage())
                .productionYear(movieEntity.getProductionYear())
                .productionCountry(movieEntity.getProductionCountry())
                .isActive(movieEntity.getIsActive())
                .build();
    }

    public MovieEntity convert(MovieCreateRequest movieCreateRequest){
        return MovieEntity.builder()
                .title(movieCreateRequest.getTitle())
                .ageLimit(movieCreateRequest.getAgeLimit())
                .durationInSec(movieCreateRequest.getMovieDuration().toSeconds())
                .director(movieCreateRequest.getDirector())
                .originalLanguage(movieCreateRequest.getOriginalLanguage())
                .productionYear(movieCreateRequest.getProductionYear())
                .productionCountry(movieCreateRequest.getProductionCountry())
                .isActive(movieCreateRequest.getIsActive())
                .build();
    }
}
