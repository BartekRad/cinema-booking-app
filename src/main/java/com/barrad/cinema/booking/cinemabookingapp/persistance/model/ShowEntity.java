package com.barrad.cinema.booking.cinemabookingapp.persistance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name = "show")
@AllArgsConstructor
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "showSequenceGenerator")
    @GenericGenerator(
            name = "showSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@Parameter(name = "sequence_name", value = "SHOW_ID_SEQ")}
    )
    private Long id;


    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime startDate;
    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false)
    private HallEntity hall;
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieEntity movie;

}
