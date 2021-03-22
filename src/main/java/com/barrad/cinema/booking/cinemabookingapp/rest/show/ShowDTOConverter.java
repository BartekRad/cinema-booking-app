package com.barrad.cinema.booking.cinemabookingapp.rest.show;

import com.barrad.cinema.booking.cinemabookingapp.domain.show.Show;
import com.barrad.cinema.booking.cinemabookingapp.domain.show.ShowCreateBulkRequest;
import com.barrad.cinema.booking.cinemabookingapp.domain.show.ShowCreateRequest;

import java.util.List;
import java.util.stream.Collectors;

public class ShowDTOConverter {

    public ShowCreateBulkRequest convert(CreateBulkShowsDTO createBulkShowsDTO){
        return ShowCreateBulkRequest.builder()
                .shows(convert(createBulkShowsDTO.getShows()))
                .movieId(createBulkShowsDTO.getMovieId())
                .build();
    }

    public ShowDTO convert(Show show){
        return ShowDTO.builder()
                .title(show.getTitle())
                .cinemaName(show.getCinemaName())
                .hallName(show.getHallName())
                .startDate(show.getShowTime().getStartDate())
                .endDate(show.getShowTime().getEndDate())
                .build();
    }

    private List<ShowCreateRequest> convert(List<CreateShowDTO> createShowDTOList){
        return createShowDTOList.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private ShowCreateRequest convert(CreateShowDTO createShowDTO){
        return ShowCreateRequest.builder()
                .showTime(new ShowTime(createShowDTO.getStartDate(), createShowDTO.getEndDate()))
                .hallId(createShowDTO.getHallId())
                .build();
    }



}
