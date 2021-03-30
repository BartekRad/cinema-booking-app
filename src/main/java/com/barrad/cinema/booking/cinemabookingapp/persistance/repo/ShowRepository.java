package com.barrad.cinema.booking.cinemabookingapp.persistance.repo;

import com.barrad.cinema.booking.cinemabookingapp.persistance.model.HallEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity, Long> {
   List<ShowEntity> findShowsByHall(HallEntity hallEntity);

   @Query("SELECT e FROM ShowEntity e WHERE e.startDate <= ?2 AND e.endDate >= ?1 AND e.hall.id = ?3")
   List<ShowEntity> findOverlappingShows(LocalDateTime startDate, LocalDateTime endDate, Long id);
}
