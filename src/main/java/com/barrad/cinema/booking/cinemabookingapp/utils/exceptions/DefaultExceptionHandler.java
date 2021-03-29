package com.barrad.cinema.booking.cinemabookingapp.utils.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(CinemaBookingException.class)
    public ResponseEntity<ErrorDTO> handleBadRequestExceptio(CinemaBookingException ex, WebRequest request){
    ErrorDTO errorDTO = new ErrorDTO(ex.getLocalizedMessage(), ex.getExceptionCode());
    return ResponseEntity
            .status(ex.getHttpStatus())
            .body(errorDTO);

    }


}
