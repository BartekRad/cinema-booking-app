package com.barrad.cinema.booking.cinemabookingapp.domain.show;

import com.barrad.cinema.booking.cinemabookingapp.persistance.model.ShowEntity;
import com.barrad.cinema.booking.cinemabookingapp.rest.show.ShowTime;

public class ShowConverter {

    public Show convert(ShowEntity showEntity) {
        return Show.builder()
                .id(showEntity.getId())
                .showTime(new ShowTime(showEntity.getStartDate(), showEntity.getEndDate()))
                .title(showEntity.getMovie().getTitle())
                .hallName(showEntity.getHall().getName())
                .cinemaName(showEntity.getHall().getCinema().getName())
                .build();

    }

    public ShowEntity convert(ShowCreateRequest showCreateRequest) {
        return ShowEntity.builder()
                .startDate(showCreateRequest.getShowTime().getStartDate())
                .endDate(showCreateRequest.getShowTime().getEndDate())
                .build();
    }


}
