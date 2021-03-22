package com.barrad.cinema.booking.cinemabookingapp.domain.booking.model;

import com.barrad.cinema.booking.cinemabookingapp.domain.show.ShowConverter;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.BookingEntity;


public class BookingConverter {
    private final ShowConverter showConverter = new ShowConverter();

    Booking convert(BookingEntity bookingEntity){
        return Booking.builder()
                .clientEmail(bookingEntity.getClientEmail())
                .bookedSeats(BookedSeats.parseSeats(bookingEntity.getSeats()))
                .show(showConverter.convert(bookingEntity.getShow()))
                .isActive(bookingEntity.getIsActive())
                .build();
    }

    BookingEntity convert (BookingCreateRequest bookingCreateRequest){
        return BookingEntity.builder()
                .clientEmail(bookingCreateRequest.getClientEmail())
                .seats(bookingCreateRequest.getBookedSeats().encodeToString())
                .isActive(bookingCreateRequest.isActive())
                .build();

    }
}
