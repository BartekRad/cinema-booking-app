package com.barrad.cinema.booking.cinemabookingapp.rest.show;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Getter
@RequiredArgsConstructor
public class ShowTime {
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
}
