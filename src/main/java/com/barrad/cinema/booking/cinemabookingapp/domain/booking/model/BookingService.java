package com.barrad.cinema.booking.cinemabookingapp.domain.booking.model;

import com.barrad.cinema.booking.cinemabookingapp.domain.hall.HallConverter;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.BookingEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.model.ShowEntity;
import com.barrad.cinema.booking.cinemabookingapp.persistance.repo.BookingRepository;
import com.barrad.cinema.booking.cinemabookingapp.persistance.repo.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final ShowRepository showRepository;
    private final HallConverter hallConverter = new HallConverter();

    private final BookingRepository bookingRepository;
    private final BookingConverter bookingConverter = new BookingConverter();


    public void createBooking(BookingCreateRequest request) {
        BookingEntity bookingEntity = bookingConverter.convert(request);
        bookingEntity.setShow(getShowEntity(request.getShowId()));
        bookingRepository.save(bookingEntity);
    }

    private ShowEntity getShowEntity(Long id) {
        return showRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("HAHA"));
    }


    public List<Booking> getBookingsByClientEmail(String clientEmail) {
        return bookingRepository.findByClientEmail(clientEmail)
                .stream()
                .map(bookingConverter::convert)
                .collect(Collectors.toList());
    }


    public Set<Seat> getAvailableSeatsByShowId(Long showId) {
        ShowEntity showEntity = getShowEntity(showId);
        Set<Seat> seats = hallConverter.convert(showEntity.getHall()).getHallSeats().generateAllSeats();
        List<BookingEntity> bookingEntities = bookingRepository.findByShow(showEntity);
        for(BookingEntity bookingEntity : bookingEntities){
            Booking booking = bookingConverter.convert(bookingEntity);
            seats.removeAll(booking.getBookedSeats().getSeats());

        }
        return seats;
    }

    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
