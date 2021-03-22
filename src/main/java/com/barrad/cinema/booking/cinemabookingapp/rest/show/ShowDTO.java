package com.barrad.cinema.booking.cinemabookingapp.rest.show;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Builder
public class ShowDTO {
    private final String title;
    private final String cinemaName;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final String hallName;
}
