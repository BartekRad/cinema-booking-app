package com.barrad.cinema.booking.cinemabookingapp.persistance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Duration;

@Data
@Entity
@Table(name = "movie")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movieSequenceGenerator")
    @GenericGenerator(
            name = "movieSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@Parameter(name = "sequence_name", value = "MOVIE_ID_SEQ")}
    )
    private Long id;
    @NotBlank
    private String title;
    @NotNull
    private Integer ageLimit = 0;
    @NotNull
    private Long durationInSec;
    @NotBlank
    private String director;

    private String originalLanguage;
    @NotNull
    private Integer productionYear;
    @NotBlank
    private String productionCountry;
    @NotNull
    private Boolean isActive;
}
