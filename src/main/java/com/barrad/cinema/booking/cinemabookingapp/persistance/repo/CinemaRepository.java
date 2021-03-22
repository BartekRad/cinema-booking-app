package com.barrad.cinema.booking.cinemabookingapp.persistance.repo;

import com.barrad.cinema.booking.cinemabookingapp.persistance.model.CinemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<CinemaEntity, Long> {
}
