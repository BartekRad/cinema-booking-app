package com.barrad.cinema.booking.cinemabookingapp.domain.booking.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BookedSeats {
    private final Set<Seat> bookedSeats;

    public Set<Seat> getSeats() {
        return new HashSet<>(bookedSeats);
    }

    public BookedSeats(Set<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public static BookedSeats parseSeats(String seats) {
        Set<Seat> seatSet = new HashSet<>();
        String[] splitted = seats.split(",");
        for (String seat : splitted) {
            seatSet.add(Seat.parse(seat));
        }

        return new BookedSeats(seatSet);
    }

    public String encodeToString(){
        return bookedSeats.stream()
                .map(Seat::encodeToString)
                .collect(Collectors.joining(","));
    }

}
