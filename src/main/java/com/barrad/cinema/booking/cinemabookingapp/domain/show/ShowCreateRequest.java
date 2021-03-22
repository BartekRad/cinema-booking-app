package com.barrad.cinema.booking.cinemabookingapp.domain.show;

import com.barrad.cinema.booking.cinemabookingapp.rest.show.ShowTime;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class ShowCreateRequest {
    private final ShowTime showTime;
    private final Long hallId;
}
