package com.example.demo.service;


import com.example.demo.model.Booking;
import com.example.demo.model.Img;
import com.example.demo.model.LocationTour;
import com.example.demo.model.Tour;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.util.List;

public interface IBaoBookingService {
    List<Tour> getAll();
    Tour findById(int id);
    List<Img> img(int id);
    List<LocationTour> findLocation (int id);
    Booking findBookingId (int id);
}