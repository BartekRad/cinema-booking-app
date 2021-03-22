package com.barrad.cinema.booking.cinemabookingapp.rest.cinema;

import com.barrad.cinema.booking.cinemabookingapp.rest.hall.CreateHallDTO;
import com.barrad.cinema.booking.cinemabookingapp.rest.hall.HallDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Builder
public class CinemaDTO {
    private final Long cinemaId;
    private final String cinemaName;
    private final List<HallDTO> halls;
    private final OpeningHoursDTO workdayHours;
    private final OpeningHoursDTO weekendHours;

}
