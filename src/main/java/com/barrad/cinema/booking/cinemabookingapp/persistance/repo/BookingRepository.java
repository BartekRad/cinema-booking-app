package com.barrad.cinema.booking.cinemabookingapp.persistance.repo;

import com.barrad.cinema.booking.cinemabookingapp.persistance.model.BookingEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.CinemaEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.HallEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    public List<BookingEntity> findByClientEmail(String clientEmail);
    public List<BookingEntity> findByShow(ShowEntity showEntity);
}
