package com.barrad.cinema.booking.cinemabookingapp.persistance.repo;

import com.barrad.cinema.booking.cinemabookingapp.persistance.model.CinemaEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.HallEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepository extends JpaRepository<HallEntity, Long> {

    public List<HallEntity> findByCinema(CinemaEntity cinemaEntity);
}
