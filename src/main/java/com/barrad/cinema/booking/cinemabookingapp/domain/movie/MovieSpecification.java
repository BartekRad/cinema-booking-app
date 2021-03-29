package com.barrad.cinema.booking.cinemabookingapp.domain.movie;

import com.barrad.cinema.booking.cinemabookingapp.persistance.model.MovieEntity;
import com.barrad.cinema.booking.cinemabookingapp.rest.movie.MovieSearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class MovieSpecification implements Specification<MovieEntity> {
    private final MovieSearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<MovieEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.and();
        if (criteria.getMovieNameLike() != null) {
            predicate = criteriaBuilder.and(predicate, getMovieNameLikePredicate(criteriaBuilder, root));
        }
        if(criteria.getAgeLimitLessThan() != null){
            predicate = criteriaBuilder.and(predicate, getAgeLimitLessThan(criteriaBuilder, root));
        }
        if(criteria.getProductionYear() != null){
            predicate = criteriaBuilder.and(predicate, getProductionYearEqual(criteriaBuilder, root));
        }
        if(criteria.getProductionCountryLike() != null){
            predicate = criteriaBuilder.and(predicate, getProductionCountryLike(criteriaBuilder, root));
        }
        if(criteria.getProductionDirectorLike() != null){
            predicate = criteriaBuilder.and(predicate, getProductionDirectorLike(criteriaBuilder, root));
        }
        return predicate;
    }

    private Predicate getMovieNameLikePredicate(CriteriaBuilder criteriaBuilder, Root<MovieEntity> root) {
        return criteriaBuilder.like(root.get("title"), "%" + criteria.getMovieNameLike() + "%");
    }

    private Predicate getAgeLimitLessThan(CriteriaBuilder criteriaBuilder, Root<MovieEntity> root){
        return criteriaBuilder.lessThanOrEqualTo(root.get("ageLimit"), criteria.getAgeLimitLessThan());
    }

    private Predicate getProductionCountryLike(CriteriaBuilder criteriaBuilder, Root<MovieEntity> root){
        return criteriaBuilder.like(root.get("productionCountry"), "%" + criteria.getProductionCountryLike() + "%");
    }

    private Predicate getProductionYearEqual(CriteriaBuilder criteriaBuilder, Root<MovieEntity> root){
        return criteriaBuilder.equal(root.get("productionYear"), criteria.getProductionYear());
    }

    private Predicate getProductionDirectorLike(CriteriaBuilder criteriaBuilder, Root<MovieEntity> root){
        return criteriaBuilder.like(root.get("director"), "%" + criteria.getProductionDirectorLike() + "%");
    }

}
