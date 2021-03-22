package com.barrad.cinema.booking.cinemabookingapp.persistance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name = "cinema")
@AllArgsConstructor
public class CinemaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cinemaIdSequenceGenerator")
    @GenericGenerator(
            name = "cinemaIdSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@Parameter(name = "sequence_name", value = "CINEMA_ID_SEQ")}
    )
    private Long id;

    private String name;

    @OneToMany(mappedBy = "cinema", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<HallEntity> halls;

    @Column(columnDefinition = "TIME")
    private LocalTime workdayStartHours;

    @Column(columnDefinition = "TIME")
    private LocalTime weekendStartHours;

    @Column(columnDefinition = "TIME")
    private LocalTime workdayEndHours;

    @Column(columnDefinition = "TIME")
    private LocalTime weekendEndHours;
}
