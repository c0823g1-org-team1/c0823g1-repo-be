package com.example.demo.service;


import com.example.demo.model.Booking;
import com.example.demo.model.LocationTour;
import com.example.demo.model.Tour;

import java.util.List;

public interface IBaoBookingService {
    List<Tour> getAll();
    Tour findById(int id);
    List<LocationTour> findLocation (int id);
    Booking findBookingId (int id);
}