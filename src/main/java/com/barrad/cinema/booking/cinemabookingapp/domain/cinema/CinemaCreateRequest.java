package com.barrad.cinema.booking.cinemabookingapp.domain.cinema;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class CinemaCreateRequest {
    private final String cinemaName;
    private final OpeningHours workdayHours;
    private final OpeningHours weekendHours;
}
