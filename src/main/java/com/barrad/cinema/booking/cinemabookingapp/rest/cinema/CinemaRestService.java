package com.barrad.cinema.booking.cinemabookingapp.rest.cinema;

import com.barrad.cinema.booking.cinemabookingapp.domain.cinema.Cinema;
import com.barrad.cinema.booking.cinemabookingapp.domain.cinema.CinemaCreateRequest;
import com.barrad.cinema.booking.cinemabookingapp.domain.cinema.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CinemaRestService {

    private final CinemaService cinemaService;
    private final CinemaDTOConverter cinemaDTOConverter = new CinemaDTOConverter();

    public void addCinema(CreateCinemaDTO createCinemaDTO) {
       CinemaCreateRequest cinemaCreateRequest = cinemaDTOConverter.convert(createCinemaDTO);
        cinemaService.createCinema(cinemaCreateRequest);
    }

    public List<CinemaDTO> getCinemas() {
       return cinemaService.getCinemas()
                .stream()
                .map(cinema -> cinemaDTOConverter.convert(cinema))
                .collect(Collectors.toList());
    }

    public void deleteCinema(Long cinemaId) {
    cinemaService.deleteCinemaById(cinemaId);

    }
}
