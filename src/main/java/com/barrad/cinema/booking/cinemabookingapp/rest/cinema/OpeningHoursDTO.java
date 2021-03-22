package com.barrad.cinema.booking.cinemabookingapp.rest.cinema;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;

@Getter
@RequiredArgsConstructor
public class OpeningHoursDTO {
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
    private final LocalTime startDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
    private final LocalTime endDate;
}
