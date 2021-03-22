package com.barrad.cinema.booking.cinemabookingapp.rest.show;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class CreateShowDTO {
    private final Long hallId;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

}
