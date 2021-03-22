package com.barrad.cinema.booking.cinemabookingapp.rest.cinema;

import com.barrad.cinema.booking.cinemabookingapp.domain.cinema.Cinema;
import com.barrad.cinema.booking.cinemabookingapp.domain.cinema.CinemaCreateRequest;
import com.barrad.cinema.booking.cinemabookingapp.domain.cinema.OpeningHours;
import com.barrad.cinema.booking.cinemabookingapp.domain.hall.model.Hall;
import com.barrad.cinema.booking.cinemabookingapp.rest.hall.HallDTO;
import com.barrad.cinema.booking.cinemabookingapp.rest.hall.HallDTOConverter;

import java.util.List;
import java.util.stream.Collectors;

public class CinemaDTOConverter {
    private final HallDTOConverter hallDTOConverter = new HallDTOConverter();


    CinemaDTO convert(Cinema cinema) {
        return CinemaDTO.builder()
                .cinemaId(cinema.getCinemaId())
                .cinemaName(cinema.getCinemaName())
                .halls(convert(cinema.getHalls()))
                .workdayHours(convert(cinema.getWorkdayHours()))
                .weekendHours(convert(cinema.getWeekendHours()))
                .build();
    }

    CinemaCreateRequest convert(CreateCinemaDTO createCinemaDTO) {
        return CinemaCreateRequest.builder()
                .cinemaName(createCinemaDTO.getCinemaName())
                .workdayHours(convert(createCinemaDTO.getWorkdayHours()))
                .weekendHours(convert(createCinemaDTO.getWeekendHours()))
                .build();
    }

    private List<HallDTO> convert(List<Hall> hallList) {

        return hallList.stream()
                .map(hall -> hallDTOConverter.convert(hall))
                .collect(Collectors.toList());
    }

    private OpeningHoursDTO convert(OpeningHours openingHours) {
        return new OpeningHoursDTO(openingHours.getStartDate(), openingHours.getEndDate());
    }

    private OpeningHours convert(OpeningHoursDTO openingHoursDTO) {
        return new OpeningHours(openingHoursDTO.getStartDate(), openingHoursDTO.getEndDate());
    }

}

