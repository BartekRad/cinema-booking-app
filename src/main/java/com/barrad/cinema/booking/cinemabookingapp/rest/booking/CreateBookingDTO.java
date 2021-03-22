package com.barrad.cinema.booking.cinemabookingapp.rest.booking;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor
public class CreateBookingDTO {
    private final String clientEmail;
    private final Set<SeatDTO> bookedSeats;
    private final Long showId;

}
