package com.barrad.cinema.booking.cinemabookingapp.domain.movie;

import com.barrad.cinema.booking.cinemabookingapp.domain.cinema.CinemaCreateRequest;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.MovieEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.repo.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieConverter movieConverter = new MovieConverter();

    public void addMovie(MovieCreateRequest movieCreateRequest){
        movieRepository.save(movieConverter.convert(movieCreateRequest));

    }

    public void changeStatus(Long id, boolean isActive){
       MovieEntity movieEntity =  movieRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("UHU"));
       movieEntity.setIsActive(isActive);
       movieRepository.save(movieEntity);
    }

}
