package com.barrad.cinema.booking.cinemabookingapp.domain.cinema;

import com.barrad.cinema.booking.cinemabookingapp.domain.hall.model.Hall;
import com.barrad.cinema.booking.cinemabookingapp.domain.hall.HallConverter;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.CinemaEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.HallEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CinemaConverter {
    private final HallConverter hallConverter = new HallConverter();

    Cinema convert(CinemaEntity cinemaEntity){
        return Cinema.builder()
                .cinemaId(cinemaEntity.getId())
                .cinemaName(cinemaEntity.getName())
                .halls(convert(cinemaEntity.getHalls()))
                .workdayHours(new OpeningHours(cinemaEntity.getWorkdayStartHours(), cinemaEntity.getWorkdayEndHours()))
                .weekendHours(new OpeningHours(cinemaEntity.getWeekendStartHours(), cinemaEntity.getWeekendEndHours()))
                .build();
    }

    private List<Hall> convert(List<HallEntity> hallEntityList){ ;
        return hallEntityList.stream()
                .map(hallEntity -> hallConverter.convert(hallEntity))
                .collect(Collectors.toList());
    }

    public CinemaEntity convert(CinemaCreateRequest cinemaCreateRequest){
        return CinemaEntity.builder()
                .name(cinemaCreateRequest.getCinemaName())
                .workdayStartHours(cinemaCreateRequest.getWorkdayHours().getStartDate())
                .workdayEndHours(cinemaCreateRequest.getWorkdayHours().getEndDate())
                .weekendStartHours(cinemaCreateRequest.getWeekendHours().getStartDate())
                .weekendEndHours(cinemaCreateRequest.getWeekendHours().getEndDate())
                .build();

    }
}
