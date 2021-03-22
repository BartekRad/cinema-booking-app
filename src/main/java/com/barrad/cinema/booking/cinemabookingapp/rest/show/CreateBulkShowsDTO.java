package com.barrad.cinema.booking.cinemabookingapp.rest.show;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class CreateBulkShowsDTO {
    private final List<CreateShowDTO> shows;
    private final Long movieId;
}
