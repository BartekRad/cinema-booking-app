package com.barrad.cinema.booking.cinemabookingapp.rest.cinema;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateCinemaDTO {
    private final String cinemaName;
    private final OpeningHoursDTO workdayHours;
    private final OpeningHoursDTO weekendHours;
}
