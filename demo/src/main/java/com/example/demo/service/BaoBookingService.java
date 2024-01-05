package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.model.Img;
import com.example.demo.model.LocationTour;
import com.example.demo.model.Tour;
import com.example.demo.repository.IBaoBookingRepository;
import com.example.demo.repository.IBaoTourRepository;
import com.example.demo.repository.IBaoImgRepository;
import com.example.demo.repository.IBaoLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaoBookingService implements IBaoBookingService {
    @Autowired
    private IBaoTourRepository baoTourRepository;
    @Autowired
    private IBaoImgRepository baoImgRepository;
    @Autowired
    private IBaoLocationRepository baoLocationRepository;
    @Autowired
    private IBaoBookingRepository baoBookingRepository;
    @Override
    public List<Tour> getAll() {
        return baoTourRepository.findAll();
    }

    @Override
    public Tour findById(int id) {
        return baoTourRepository.findById(id).get();
    }

    @Override
    public List<Img> img(int id) {
        return baoImgRepository.img(id);
    }

    @Override
    public List<LocationTour> findLocation(int id) {
        return baoLocationRepository.findLocation(id);
    }

    @Override
    public Booking findBookingId(int id) {
        return baoBookingRepository.findBookingId(id);
    }


}
