package com.barrad.cinema.booking.cinemabookingapp.domain.hall.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class HallCreateRequest {
    private final Long cinemaId;
    private final String name;
    private final HallSeats hallSeats;
    private final boolean isAvailable;
}
