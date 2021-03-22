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
import java.util.Map;

@Data
@Entity
@Builder
@Table(name = "hall")
@NoArgsConstructor
@AllArgsConstructor
public class HallEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hallSequenceGenerator")
    @GenericGenerator(
            name = "hallSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@Parameter(name = "sequence_name", value = "HALL_ID_SEQ")}
    )
    private Long Id;

    @NotBlank
    private String seats;

    @NotBlank
    private String name;

    @NotNull
    private Boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    private CinemaEntity cinema;

}
