package com.barrad.cinema.booking.cinemabookingapp.domain.hall;

import com.barrad.cinema.booking.cinemabookingapp.domain.hall.model.Hall;
import com.barrad.cinema.booking.cinemabookingapp.domain.hall.model.HallCreateRequest;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.CinemaEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.HallEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.repo.CinemaRepository;
import com.barrad.cinema.booking.cinemabookingapp.persistance.repo.HallRepository;
import com.barrad.cinema.booking.cinemabookingapp.utils.exceptions.CinemaBookingNotFoundException;
import com.barrad.cinema.booking.cinemabookingapp.utils.exceptions.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HallService {
    private final HallRepository hallRepository;
    private final CinemaRepository cinemaRepository;
    private final HallConverter hallConverter = new HallConverter();

    public void createHall(HallCreateRequest hallCreateRequest) {
        HallEntity hallEntity = hallConverter.convert(hallCreateRequest);
        CinemaEntity cinemaEntity = getCinemaEntity(hallCreateRequest.getCinemaId());
        hallEntity.setCinema(cinemaEntity);
        hallRepository.save(hallEntity);
    }

    private CinemaEntity getCinemaEntity(Long cinemaId) {
        CinemaEntity cinemaEntity = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new CinemaBookingNotFoundException(String.format("Cinema with id = %d not found", cinemaId), ExceptionCode.CINEMA_NOT_FOUND));
        return cinemaEntity;
    }

    public void deleteHallById(Long id) {
        hallRepository.deleteById(id);
    }

    public List<Hall> getHallsByCinemaId(Long id) {
        CinemaEntity cinemaEntity = getCinemaEntity(id);
        return hallRepository.findByCinema(cinemaEntity)
                .stream()
                .map(hallConverter::convert)
                .collect(Collectors.toList());
    }


}
