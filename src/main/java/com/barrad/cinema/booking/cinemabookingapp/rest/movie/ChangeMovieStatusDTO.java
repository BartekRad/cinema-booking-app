package com.barrad.cinema.booking.cinemabookingapp.rest.movie;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ChangeMovieStatusDTO {
    private final boolean isActive;
}
