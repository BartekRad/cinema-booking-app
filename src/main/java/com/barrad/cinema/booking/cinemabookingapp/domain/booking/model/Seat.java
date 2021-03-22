package com.barrad.cinema.booking.cinemabookingapp.domain.booking.model;

import com.barrad.cinema.booking.cinemabookingapp.domain.hall.model.RowId;
import lombok.Builder;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Builder
public class Seat {
    private final RowId rowId;
    private final int seatNumber;
    private static final Pattern SEAT_REGEX = Pattern.compile("([a-zA-Z]+):([0-9]+)");

    public Seat(RowId rowId, int seatNumber) {
        this.rowId = rowId;
        this.seatNumber = seatNumber;
    }

    public static Seat parse(String seat) {


        Matcher matcher = SEAT_REGEX.matcher(seat);
        if (!matcher.matches()) {
            throw new IllegalStateException("HAHA");
        }
        String id = matcher.group(1);
        int seatsNumber = Integer.parseInt(matcher.group(2));
        return new Seat(RowId.valueOf(id), seatsNumber);
    }

    public String encodeToString() {
        return rowId + ":" + seatNumber;
    }
}
