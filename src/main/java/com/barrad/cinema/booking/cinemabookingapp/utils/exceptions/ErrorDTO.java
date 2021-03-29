package com.barrad.cinema.booking.cinemabookingapp.utils.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@RequiredArgsConstructor
public class ErrorDTO {
    private final String message;
    private final ExceptionCode exceptionCode;
}
