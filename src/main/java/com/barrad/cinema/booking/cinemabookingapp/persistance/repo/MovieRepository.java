package com.barrad.cinema.booking.cinemabookingapp.persistance.repo;

import com.barrad.cinema.booking.cinemabookingapp.persistance.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long>, JpaSpecificationExecutor<MovieEntity> {
}
