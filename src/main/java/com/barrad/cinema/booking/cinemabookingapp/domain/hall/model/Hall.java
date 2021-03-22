package com.barrad.cinema.booking.cinemabookingapp.domain.hall.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Hall {
    private final Long hallId;
    private final HallSeats hallSeats;
    private final String name;
    private final boolean isAvailable;

}
