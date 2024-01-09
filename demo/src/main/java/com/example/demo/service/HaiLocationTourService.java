package com.example.demo.service;

import com.example.demo.model.LocationTour;
import com.example.demo.repository.IHaiTourRepository;
import com.example.demo.repository.ILocationTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HaiLocationTourService implements IHaiLocationTourService{
    @Autowired
    private ILocationTourRepository locationTourRepository;

    @Override
    public List<LocationTour> findAll() {
        return locationTourRepository.findAll();
    }
}
