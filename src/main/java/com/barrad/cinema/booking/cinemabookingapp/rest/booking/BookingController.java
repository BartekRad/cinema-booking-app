package com.barrad.cinema.booking.cinemabookingapp.rest.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;


@Validated
@RestController
@RequestMapping("bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingRestService bookingRestService;


    @PostMapping
    public void createBooking(@RequestBody CreateBookingDTO createBookingDTO) {
        bookingRestService.createBooking(createBookingDTO);
    }

    @GetMapping
    public List<BookingDTO> getBookingsByClientEmail(@RequestParam("clientEmail") @NotBlank String clientEmail) {
        return bookingRestService.getBookingsByClientEmail(clientEmail);
    }

    @GetMapping("/seats")
    public Set<SeatDTO> getAvailableSeatsByShowId(@RequestParam("showId") @NotBlank Long showId){
        return bookingRestService.getAvailableSeatsByShowId(showId);
    }

    @DeleteMapping("{id}")
    public void cancelBooking(@PathVariable(value = "id") @NotBlank Long bookingId){
        bookingRestService.deleteBooking(bookingId);
    }




}
