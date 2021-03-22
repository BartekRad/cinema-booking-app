package com.barrad.cinema.booking.cinemabookingapp.domain.hall.model;

import com.barrad.cinema.booking.cinemabookingapp.domain.booking.model.Seat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HallSeats {
    private final Map<RowId, Integer> seatsByRow;
    private static final Pattern ROW_REGEX = Pattern.compile("([a-zA-Z]+):([0-9]+)");

    public Map<RowId, Integer> getSeatsByRow() {
        return new HashMap<>(seatsByRow);
    }

    private HallSeats(Map<RowId, Integer> seatsByRow) {
        this.seatsByRow = seatsByRow;
    }


    public static HallSeats parseSeats(String seats) {
        Map<RowId, Integer> map = new HashMap<>();
        String[] splitted = seats.split(",");
        for (String row : splitted) {
            Matcher matcher = ROW_REGEX.matcher(row);
            if (!matcher.matches()) {
                throw new IllegalStateException("HAHA");
            }
            RowId id = RowId.valueOf(matcher.group(1));
            Integer seatsNumber = Integer.parseInt(matcher.group(2));
            map.put(id, seatsNumber);
        }

        return new HallSeats(map);
    }

    public static HallSeats createSeatsFromMap(Map<String, Integer> stringIntegerMap) {
        Map<RowId, Integer> seatsByRow = stringIntegerMap
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> RowId.valueOf(e.getKey()), e -> e.getValue()));
        return new HallSeats(seatsByRow);

    }

    public String encodeToString() {
        return seatsByRow.entrySet()
                .stream()
                .map(row -> row.getKey().getId() + ":" + row.getValue())
                .collect(Collectors.joining(","));
    }

    public Set<Seat> generateAllSeats() {
        Set<Seat> seats = new HashSet<>();
        for (RowId row : seatsByRow.keySet()) {
            for(int i = 1; i<=seatsByRow.get(row); i++){
                seats.add(new Seat(row, i));
            }
        }
        return seats;
    }


}
