package com.barrad.cinema.booking.cinemabookingapp.rest.hall;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("hall")
@RequiredArgsConstructor
public class HallController {
    private final HallRestService hallRestService;

    @GetMapping
    public List<HallDTO> getHallsByCinemaId(@RequestParam("cinemaId") @NotNull Long cinemaId) {
        return hallRestService.getHallsByCinemaId(cinemaId);
    }

    @PostMapping
    public void addHall(@RequestBody CreateHallDTO createHallDTO) {
        hallRestService.addHall(createHallDTO);
    }

    @DeleteMapping
    public void deleteHall(@RequestParam("hallId") @NotNull Long hallId){
        hallRestService.deleteHall(hallId);
    }


}
