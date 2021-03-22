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

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name = "booking ")
@AllArgsConstructor
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingIdSequenceGenerator")
    @GenericGenerator(
            name = "bookingIdSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@Parameter(name = "sequence_name", value = "BOOKING_ID_SEQ")}
    )
    private Long id;
    @NotBlank
    private String clientEmail;
    @NotBlank
    private String seats;
    @NotNull
    private Boolean isActive;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "show_id", nullable = false)
    private ShowEntity show;


}
