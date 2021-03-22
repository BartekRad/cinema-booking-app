package com.barrad.cinema.booking.cinemabookingapp.rest.movie;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Builder
@RequiredArgsConstructor
public class MovieSpecification {
     private final String movieNameLike;
     private final String cinemaName;
     private final String ageLimit;
     private final Integer productionYear;
     private final String productionCountry;
     private final String productionDirector;
     private final int pageNo;
     private final int pageSize;

}
