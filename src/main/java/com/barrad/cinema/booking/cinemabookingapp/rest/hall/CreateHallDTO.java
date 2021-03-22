package com.barrad.cinema.booking.cinemabookingapp.rest.hall;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@RequiredArgsConstructor
public class CreateHallDTO {
    private final Long cinemaId;
    private final String name;
    private final Map<String, Integer> seatsByRows;
    private final boolean isAvailable;
}
