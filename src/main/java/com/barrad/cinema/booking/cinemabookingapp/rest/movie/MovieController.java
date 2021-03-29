package com.barrad.cinema.booking.cinemabookingapp.rest.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieRestService movieRestService;

    @GetMapping
    public List<MovieDTO> getMovies(@RequestParam(value = "cinemaName", required = false) String cinemaName,
                                     @RequestParam(value = "ageLimit", required = false) String ageLimit,
                                     @RequestParam(value = "productionYear", required = false) Integer productionYear,
                                     @RequestParam(value = "productionCountry", required = false) String productionCountry,
                                     @RequestParam(value = "productionDirector", required = false) String productionDirector,
                                     @RequestParam(value = "movieNameLike", required = false) String movieNameLike,
                                     @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
                                     @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                     @RequestParam(value = "sortOrder", defaultValue = "ASC") SortOrder sortOrder,
                                     @RequestParam(value = "sortBy", defaultValue = "title") String sortBy)
    {
        MovieSearchCriteria movieSearchCriteria = MovieSearchCriteria.builder()
                .ageLimitLessThan(ageLimit)
                .cinemaNameLike(cinemaName)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .productionCountryLike(productionCountry)
                .productionYear(productionYear)
                .productionDirectorLike(productionDirector)
                .movieNameLike(movieNameLike)
                .sortOrder(sortOrder)
                .sortBy(sortBy)
                .build();
        return movieRestService.getMovies(movieSearchCriteria);
    }


    @PostMapping
    public void addMovie(@RequestBody CreateMovieDTO createMovieDTO){
        movieRestService.addMovie(createMovieDTO);
    }

    @PutMapping("{id}")
    public void changeStatus(@PathVariable(value = "id") Long movieID, @RequestBody ChangeMovieStatusDTO changeMovieStatusDTO){
        movieRestService.changeStatus(movieID, changeMovieStatusDTO);
    }

}
