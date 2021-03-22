package com.barrad.cinema.booking.cinemabookingapp.domain.cinema;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;
@Getter
@RequiredArgsConstructor
public class OpeningHours {
    private final LocalTime startDate;
    private final LocalTime endDate;
}
