package com.example.demo.service;

import com.example.demo.model.LocationTour;
import com.example.demo.repository.IHaiTourRepository;
import com.example.demo.repository.ILocationTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class HaiLocationTourService implements IHaiLocationTourService{
    @Autowired
    private ILocationTourRepository locationTourRepository;

    @Override
    public List<LocationTour> findAll() {
        return locationTourRepository.findAll();
    }

    @Override
    public void save(LocationTour locationTour) {
        locationTourRepository.save(locationTour);
    }

    @Override
    public Optional<LocationTour> findById(int id) {
        return locationTourRepository.findById(id);
    }

    @Override
    public List<LocationTour> findAllByTour_Id(int id) {
        return locationTourRepository.findAllByTour_Id(id);
    }

    @Override
    public void deleteById(int id) {
        locationTourRepository.deleteById(id);
    }

    @Override
    public void delete(LocationTour locationTour) {
        locationTourRepository.delete(locationTour);
    }


}
