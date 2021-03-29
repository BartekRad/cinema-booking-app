package com.barrad.cinema.booking.cinemabookingapp.persistance.repo;

import com.barrad.cinema.booking.cinemabookingapp.persistance.model.HallEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity, Long> {
   List<ShowEntity> findShowsByHall(HallEntity hallEntity);
}
