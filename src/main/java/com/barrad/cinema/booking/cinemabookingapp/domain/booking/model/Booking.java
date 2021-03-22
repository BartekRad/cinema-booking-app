package com.barrad.cinema.booking.cinemabookingapp.domain.booking.model;

import com.barrad.cinema.booking.cinemabookingapp.domain.show.Show;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Booking {
    private final Long bookingId;
    private final String clientEmail;
    private final BookedSeats bookedSeats;
    private final Show show;
    private final boolean isActive;
}
