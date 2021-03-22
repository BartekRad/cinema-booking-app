package com.barrad.cinema.booking.cinemabookingapp.domain.show;

import com.barrad.cinema.booking.cinemabookingapp.rest.show.ShowTime;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class Show {
    private final Long id;
    private final String title;
    private final String cinemaName;
    private final ShowTime showTime;
    private final String hallName;
}
