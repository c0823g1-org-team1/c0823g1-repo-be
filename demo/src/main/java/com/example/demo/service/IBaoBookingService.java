package com.example.demo.service;


import com.example.demo.model.Booking;
import com.example.demo.model.LocationTour;
import com.example.demo.model.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBaoBookingService {
    List<Tour> getAll();

    Tour findById(int id);

    List<LocationTour> findLocation(int id);

    void saveTour(Tour tour);

    //    Page<Tour> getAllTour(int price, Pageable pageable);
    List<Tour> findAllByOrderByAdultPriceAsc();

    List<Tour> findAllByOrderByAdultPriceDesc();
}