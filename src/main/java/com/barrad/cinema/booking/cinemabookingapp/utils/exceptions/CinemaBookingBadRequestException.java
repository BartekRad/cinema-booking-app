package com.barrad.cinema.booking.cinemabookingapp.utils.exceptions;

import org.springframework.http.HttpStatus;

public class CinemaBookingBadRequestException extends CinemaBookingException{

    public CinemaBookingBadRequestException(String message, ExceptionCode exceptionCode) {
        super(message, exceptionCode, HttpStatus.BAD_REQUEST);
    }
}
