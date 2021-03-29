package com.barrad.cinema.booking.cinemabookingapp.rest.booking;

import com.barrad.cinema.booking.cinemabookingapp.domain.booking.model.BookingConverter;
import com.barrad.cinema.booking.cinemabookingapp.domain.booking.model.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingRestService {
    private final BookingService bookingService;
    private final BookingDTOConverter bookingDTOConverter = new BookingDTOConverter();

    public void createBooking(CreateBookingDTO createBookingDTO) {
        bookingService.createBooking(bookingDTOConverter.convert(createBookingDTO));

    }

    public List<BookingDTO> getBookingsByClientEmail(String clientEmail) {
        return bookingService.getBookingsByClientEmail(clientEmail)
                .stream()
                .map(bookingDTOConverter::convert)
                .collect(Collectors.toList());
    }

    public Set<SeatDTO> getAvailableSeatsByShowId(Long showId) {
        return bookingDTOConverter.convertSeats(bookingService.getAvailableSeatsByShowId(showId));
    }

    public void deleteBooking(Long bookingId) {
        bookingService.deleteBooking(bookingId);

    }
}
