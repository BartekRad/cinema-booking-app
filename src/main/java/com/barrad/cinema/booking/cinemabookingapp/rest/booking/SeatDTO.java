package com.barrad.cinema.booking.cinemabookingapp.rest.booking;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
@Builder
public class SeatDTO {

    private final String rowId;
    private final int seatNumber;

}
