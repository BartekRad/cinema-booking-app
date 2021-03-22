package com.barrad.cinema.booking.cinemabookingapp.rest.hall;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
@Getter
@Builder
@RequiredArgsConstructor
public class HallDTO {

    private final Long hallId;
    private final Map<String, Integer> seatsByRows;
    private final String name;
    private final boolean isAvailable;

}
