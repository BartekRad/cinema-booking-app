package com.barrad.cinema.booking.cinemabookingapp.domain.hall

import com.barrad.cinema.booking.cinemabookingapp.domain.hall.model.RowId
import com.barrad.cinema.booking.cinemabookingapp.domain.hall.model.HallSeats
import spock.lang.Specification

class HallSeatsTest extends Specification {

    private static Map<String, Integer> extractRawId(Map<RowId, Integer> map){
        return map.collectEntries { key, value -> [key.getId(), value]} as Map<String, Integer>
    }
    private static Map<RowId, Integer> transformToRawId(Map<String, Integer> map){
        return map.collectEntries {key, value ->[RowId.valueOf(key), value]} as Map<RowId, Integer>
    }

    def "should correctly parse seats"(){
        expect:
        extractRawId(HallSeats.parseSeats(encodedSeats).getSeatsByRow()) == seatsMap

        where:
        encodedSeats        || seatsMap
        "AB:1245,CD:0,EF:9" || [AB:1245,CD:0,EF:9]
        "u:0"               || [u:0]

    }

    def "should throw exception while parsing seats"(){
        when:
        HallSeats.parseSeats(encodedSeats)

        then:
        thrown(Exception)

        where:
        encodedSeats << [
                " ",
                " : ",
                " : ,u:8",
                "U: ",
                " :8",
                "aq78:sad",
                "A__B:12345",
                ""
        ]

    }

    def "should correctly parse Seats to String"(){
        expect:
        new HallSeats(transformToRawId(seatsMap)).encodeToString() == encodedSeats

        where:
        seatsMap            || encodedSeats
        [AB:1245,CD:0,EF:9] || "AB:1245,CD:0,EF:9"
        [u:0]               || "u:0"

    }

}
