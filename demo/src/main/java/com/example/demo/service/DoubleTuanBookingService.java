package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.repository.DoubleTuanBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoubleTuanBookingService implements IDoubleTuanBookingService {
    @Autowired
    private DoubleTuanBookingRepository doubleTuanBookingRepository;

    @Override
    public Page<Booking> getAllBookingPage(Pageable pageable, String name) {
        return doubleTuanBookingRepository.getAllBookingPage(pageable, name);
    }

    @Override
    public void save(Booking booking) {
        doubleTuanBookingRepository.save(booking);
    }

    @Override
    public Booking findById(int id) {
        return doubleTuanBookingRepository.findById(id).get();
    }

    public List<Booking> getList() {
        return doubleTuanBookingRepository.findAll();
    }
}
