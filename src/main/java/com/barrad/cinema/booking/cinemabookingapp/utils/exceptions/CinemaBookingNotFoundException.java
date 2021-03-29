package com.barrad.cinema.booking.cinemabookingapp.utils.exceptions;

import org.springframework.http.HttpStatus;

public class CinemaBookingNotFoundException extends CinemaBookingException{
    public CinemaBookingNotFoundException(String message, ExceptionCode exceptionCode) {
        super(message, exceptionCode, HttpStatus.NOT_FOUND);
    }
}
