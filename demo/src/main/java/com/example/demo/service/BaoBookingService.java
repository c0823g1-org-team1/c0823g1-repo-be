package com.example.demo.service;

import com.example.demo.dto.TourDTO;
import com.example.demo.model.Img;
import com.example.demo.model.Tour;
import com.example.demo.repository.IBaoBookingRepository;
import com.example.demo.repository.IBaoImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaoBookingService implements IBaoBookingService {
    @Autowired
    private IBaoBookingRepository baoBookingRepository;
    @Autowired
    private IBaoImgRepository baoImgRepository;
    @Override
    public List<Tour> getAll() {
        return baoBookingRepository.findAll();
    }

    @Override
    public Tour findById(int id) {
        return baoBookingRepository.findById(id).get();
    }

    @Override
    public List<Img> img(int id) {
        return baoImgRepository.img(id);
    }


}
