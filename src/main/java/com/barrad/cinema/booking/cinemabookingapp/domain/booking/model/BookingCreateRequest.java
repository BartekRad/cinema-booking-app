package com.barrad.cinema.booking.cinemabookingapp.domain.booking.model;

import com.barrad.cinema.booking.cinemabookingapp.domain.show.Show;
import com.barrad.cinema.booking.cinemabookingapp.rest.show.ShowDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@Builder
@RequiredArgsConstructor
public class BookingCreateRequest {
    private final String clientEmail;
    private final BookedSeats bookedSeats;
    private final Long showId;
    private final boolean isActive;

}
