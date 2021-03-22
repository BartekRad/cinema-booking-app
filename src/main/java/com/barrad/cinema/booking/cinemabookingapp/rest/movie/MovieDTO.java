package com.barrad.cinema.booking.cinemabookingapp.rest.movie;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
@Getter
@Builder
@RequiredArgsConstructor
public class MovieDTO {
    private final Long movieId;
    private final String title;
    private final Integer ageLimit;
    private final Duration movieDuration;
    private final String director;
    private final String originalLanguage;
    private final Integer productionYear;
    private final String productionCountry;
    private final Boolean isActive;
}
