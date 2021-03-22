package com.barrad.cinema.booking.cinemabookingapp.domain.hall;

import com.barrad.cinema.booking.cinemabookingapp.domain.hall.model.Hall;
import com.barrad.cinema.booking.cinemabookingapp.domain.hall.model.HallCreateRequest;
import com.barrad.cinema.booking.cinemabookingapp.domain.hall.model.HallSeats;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.HallEntity;

public class HallConverter {

    public Hall convert(HallEntity hallEntity){
        return Hall.builder()
                .hallId(hallEntity.getId())
                .name(hallEntity.getName())
                .isAvailable(hallEntity.getIsAvailable())
                .hallSeats(HallSeats.parseSeats(hallEntity.getSeats()))
                .build();
    }

    public HallEntity convert(HallCreateRequest hallCreateRequest){
        return HallEntity.builder()
                .seats(hallCreateRequest.getHallSeats().encodeToString())
                .name(hallCreateRequest.getName())
                .isAvailable(hallCreateRequest.isAvailable())
                .build();
    }
}
