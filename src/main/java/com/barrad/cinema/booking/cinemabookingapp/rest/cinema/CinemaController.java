package com.barrad.cinema.booking.cinemabookingapp.rest.cinema;

import com.barrad.cinema.booking.cinemabookingapp.utils.exceptions.CinemaBookingBadRequestException;
import com.barrad.cinema.booking.cinemabookingapp.utils.exceptions.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("cinema")
@RequiredArgsConstructor
public class CinemaController {

    private final CinemaRestService cinemaRestService;

    @PostMapping
    public void addCinema(@RequestBody CreateCinemaDTO createCinemaDTO) {
        cinemaRestService.addCinema(createCinemaDTO);
    }

    @GetMapping
    public List<CinemaDTO> getCinemas() {

      return cinemaRestService.getCinemas();
    }

    @DeleteMapping("{id}")
    public void deleteCinema(@PathVariable(value = "id") @NotNull Long cinemaId){
        cinemaRestService.deleteCinema(cinemaId);
    }

}
