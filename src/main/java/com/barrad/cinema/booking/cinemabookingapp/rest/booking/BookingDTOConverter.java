package com.barrad.cinema.booking.cinemabookingapp.rest.booking;

import com.barrad.cinema.booking.cinemabookingapp.domain.booking.model.BookedSeats;
import com.barrad.cinema.booking.cinemabookingapp.domain.booking.model.Booking;
import com.barrad.cinema.booking.cinemabookingapp.domain.booking.model.BookingCreateRequest;
import com.barrad.cinema.booking.cinemabookingapp.domain.booking.model.Seat;
import com.barrad.cinema.booking.cinemabookingapp.domain.hall.model.RowId;
import com.barrad.cinema.booking.cinemabookingapp.rest.show.ShowDTOConverter;

import java.util.Set;
import java.util.stream.Collectors;

public class BookingDTOConverter {
    private final ShowDTOConverter showDTOConverter = new ShowDTOConverter();

    public BookingDTO convert(Booking booking) {
        return BookingDTO.builder()
                .bookingId(booking.getBookingId())
                .clientEmail(booking.getClientEmail())
                .bookedSeats(convertSeats(booking.getBookedSeats().getSeats()))
                .showDTO(showDTOConverter.convert(booking.getShow()))
                .isActive(booking.isActive())
                .build();
    }

    public Set<SeatDTO> convertSeats(Set<Seat> seats) {
        return seats.stream()
                .map(this::convert)
                .collect(Collectors.toSet());
    }

    public SeatDTO convert(Seat seat) {
        return SeatDTO.builder()
                .rowId(seat.getRowId().getId())
                .seatNumber(seat.getSeatNumber())
                .build();
    }

    public Seat convert(SeatDTO seatDTO) {
        return Seat.builder()
                .rowId(RowId.valueOf(seatDTO.getRowId()))
                .seatNumber(seatDTO.getSeatNumber())
                .build();
    }

    public Set<Seat> convertSeatsDTO(Set<SeatDTO> seats) {
        return seats.stream()
                .map(this::convert)
                .collect(Collectors.toSet());

    }

    public BookingCreateRequest convert(CreateBookingDTO createBookingDTO) {
        return BookingCreateRequest.builder()
                .clientEmail(createBookingDTO.getClientEmail())
                .bookedSeats(new BookedSeats(convertSeatsDTO(createBookingDTO.getBookedSeats())))
                .showId(createBookingDTO.getShowId())
                .build();
    }

}
