package com.barrad.cinema.booking.cinemabookingapp.rest.hall;

import com.barrad.cinema.booking.cinemabookingapp.domain.hall.model.Hall;
import com.barrad.cinema.booking.cinemabookingapp.domain.hall.model.HallCreateRequest;
import com.barrad.cinema.booking.cinemabookingapp.domain.hall.model.HallSeats;

import java.util.Map;
import java.util.stream.Collectors;

public class HallDTOConverter {

    public HallDTO convert(Hall hall){
        return HallDTO.builder()
                .hallId(hall.getHallId())
                .name(hall.getName())
                .isAvailable(hall.isAvailable())
                .seatsByRows(extractRawId(hall))
                .build();
    }

    public HallCreateRequest convert(CreateHallDTO createHallDTO){
        return HallCreateRequest.builder()
                .cinemaId(createHallDTO.getCinemaId())
                .name(createHallDTO.getName())
                .hallSeats(HallSeats.createSeatsFromMap(createHallDTO.getSeatsByRows()))
                .isAvailable(createHallDTO.isAvailable())
                .build();
    }


    public  Map<String, Integer> extractRawId(Hall hall){
        return hall.getHallSeats()
                .getSeatsByRow()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().getId(), e -> e.getValue()));
    }
}

