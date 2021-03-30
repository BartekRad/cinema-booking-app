package com.barrad.cinema.booking.cinemabookingapp.domain.hall.model;

import com.barrad.cinema.booking.cinemabookingapp.utils.exceptions.CinemaBookingBadRequestException;
import com.barrad.cinema.booking.cinemabookingapp.utils.exceptions.ExceptionCode;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class RowId {
    private final String id;
    private static final Pattern RAW_ID_REGEX = Pattern.compile("[a-zA-Z]+");

    private RowId(String id) {
        this.id = id;
    }

    public static RowId valueOf(String id){
        validate(id);
        return new RowId(id);
    }

    private static void validate(String id) {
        Matcher matcher = RAW_ID_REGEX.matcher(id);
        if(!matcher.matches()){
            throw new CinemaBookingBadRequestException("RowId wrong format", ExceptionCode.WRONG_ROWID_FORMAT);
        }
    }
}
