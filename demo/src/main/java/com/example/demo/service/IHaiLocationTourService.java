package com.example.demo.service;

import com.example.demo.model.LocationTour;

import java.util.List;
import java.util.Optional;

public interface IHaiLocationTourService {
    List<LocationTour> findAll();

    void save(LocationTour locationTour);


    Optional<LocationTour> findById(int id);

    List<LocationTour> findAllByTour_Id(int id);

    void deleteById(int id);

    void delete(LocationTour locationTour);
}
