package com.barrad.cinema.booking.cinemabookingapp.rest.movie;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Builder
@RequiredArgsConstructor
public class MovieSearchCriteria {
     private final String movieNameLike;
     private final String cinemaNameLike;
     private final String ageLimitLessThan;
     private final Integer productionYear;
     private final String productionCountryLike;
     private final String productionDirectorLike;
     private final int pageNo;
     private final int pageSize;
private final String sortBy;
private final SortOrder sortOrder;
}
