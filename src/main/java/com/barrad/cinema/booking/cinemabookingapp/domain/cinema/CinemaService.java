package com.barrad.cinema.booking.cinemabookingapp.domain.cinema;

import com.barrad.cinema.booking.cinemabookingapp.persistance.model.CinemaEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.repo.CinemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CinemaService {
private final CinemaConverter cinemaConverter = new CinemaConverter();
private final CinemaRepository cinemaRepository;

   public List<Cinema> getCinemas(){
    return cinemaRepository.findAll()
            .stream()
            .map(cinemaEntity -> cinemaConverter.convert(cinemaEntity))
            .collect(Collectors.toList());
   }

   public void createCinema(CinemaCreateRequest cinemaCreateRequest){
       cinemaRepository.save(cinemaConverter.convert(cinemaCreateRequest));

   }

   public void deleteCinemaById(Long id){
       cinemaRepository.deleteById(id);
   }
}
