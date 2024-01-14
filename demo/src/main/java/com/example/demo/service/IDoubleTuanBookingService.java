package com.example.demo.service;

import com.example.demo.model.Booking;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDoubleTuanBookingService {
    Page<Booking> getAllBookingPage(Pageable pageable, String name);

    void save(Booking booking);

    Booking findById(int id);

    List<Booking> getList();
}
