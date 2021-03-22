package com.barrad.cinema.booking.cinemabookingapp.domain.show;

import com.barrad.cinema.booking.cinemabookingapp.rest.show.CreateShowDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class ShowCreateBulkRequest {
    private final List<ShowCreateRequest> shows;
    private final Long movieId;
}
