package com.example.demo.service;

import com.example.demo.model.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IHaiTourService {
    Page<Tour> findAll(Pageable pageable);

    Optional<Tour> findById(int id);

    void save(Tour tour);

    void deleteById(int id);


    Page<Tour> findAllByNameContaining(String name, Pageable pageable);
}
