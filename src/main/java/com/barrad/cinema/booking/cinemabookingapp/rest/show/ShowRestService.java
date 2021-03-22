package com.barrad.cinema.booking.cinemabookingapp.rest.show;

import com.barrad.cinema.booking.cinemabookingapp.domain.show.Show;
import com.barrad.cinema.booking.cinemabookingapp.domain.show.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowRestService {
    private final ShowService showService;
    private final ShowDTOConverter showDTOConverter = new ShowDTOConverter();

    public void addShows(CreateBulkShowsDTO createBulkShowsDTO) {
        showService.addShows(showDTOConverter.convert(createBulkShowsDTO));
    }

    public List<ShowDTO> getShowsByHallId(Long hallId) {
        return showService.getShowsByHallId(hallId)
                .stream()
                .map(showDTOConverter::convert)
                .collect(Collectors.toList());
    }
}
