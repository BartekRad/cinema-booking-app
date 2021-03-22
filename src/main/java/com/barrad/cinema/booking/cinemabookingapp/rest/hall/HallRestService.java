package com.barrad.cinema.booking.cinemabookingapp.rest.hall;

import com.barrad.cinema.booking.cinemabookingapp.domain.hall.model.HallCreateRequest;
import com.barrad.cinema.booking.cinemabookingapp.domain.hall.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HallRestService {
    private final HallDTOConverter hallDTOConverter = new HallDTOConverter();
    private final HallService hallService;

    public List<HallDTO> getHallsByCinemaId(Long cinemaId) {
        return hallService.getHallsByCinemaId(cinemaId)
                .stream()
                .map(hall -> hallDTOConverter.convert(hall))
                .collect(Collectors.toList());
    }

    public void addHall(CreateHallDTO createHallDTO) {
        HallCreateRequest hallCreateRequest = hallDTOConverter.convert(createHallDTO);
        hallService.createHall(hallCreateRequest);
    }


    public void deleteHall(Long hallId) {
        hallService.deleteHallById(hallId);

    }
}
