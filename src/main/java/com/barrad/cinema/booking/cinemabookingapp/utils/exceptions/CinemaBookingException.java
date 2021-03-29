package com.barrad.cinema.booking.cinemabookingapp.utils.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class CinemaBookingException extends RuntimeException{
    private final ExceptionCode exceptionCode;

    private final HttpStatus httpStatus;

    public CinemaBookingException(String message, ExceptionCode exceptionCode, HttpStatus httpStatus) {
        super(message);
        this.exceptionCode = exceptionCode;
        this.httpStatus = httpStatus;
    }

    public CinemaBookingException(String message, ExceptionCode exceptionCode) {
        super(message);
        this.exceptionCode = exceptionCode;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }


}
