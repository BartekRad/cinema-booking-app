package com.barrad.cinema.booking.cinemabookingapp.rest.show;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Validated
@RestController
@RequestMapping("shows")
@RequiredArgsConstructor
public class ShowController {
    private final ShowRestService showRestService;

    @GetMapping
    public List<ShowDTO> getShowsByHallId (@RequestParam("hallId") @NotBlank Long hallId) {
        return showRestService.getShowsByHallId(hallId);
    }

    @PostMapping
    public void addShows(@RequestBody CreateBulkShowsDTO createBulkShowsDTO){
        showRestService.addShows(createBulkShowsDTO);
    }


}
