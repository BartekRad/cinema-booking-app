package com.barrad.cinema.booking.cinemabookingapp.domain.cinema;

import com.barrad.cinema.booking.cinemabookingapp.domain.hall.model.Hall;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Getter
@Builder
@RequiredArgsConstructor
public class Cinema {
    private final Long cinemaId;
    private final String cinemaName;
    private final List<Hall> halls;
    private final OpeningHours workdayHours;
    private final OpeningHours weekendHours;
}
