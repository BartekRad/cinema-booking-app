package com.barrad.cinema.booking.cinemabookingapp.rest.booking;

import com.barrad.cinema.booking.cinemabookingapp.rest.show.ShowDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@Builder
@RequiredArgsConstructor
public class BookingDTO {
    private final Long bookingId;
    private final String clientEmail;
    private final Set<SeatDTO> bookedSeats;
    private final ShowDTO showDTO;
    private final boolean isActive;
}
