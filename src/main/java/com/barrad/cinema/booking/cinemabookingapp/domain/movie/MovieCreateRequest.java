package com.barrad.cinema.booking.cinemabookingapp.domain.movie;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
@Builder
@Getter
@RequiredArgsConstructor
public class MovieCreateRequest {
    private final String title;
    private final Integer ageLimit;
    private final Duration movieDuration;
    private final String director;
    private final String originalLanguage;
    private final Integer productionYear;
    private final String productionCountry;
    private final Boolean isActive;
}
