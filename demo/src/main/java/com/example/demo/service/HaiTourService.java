package com.example.demo.service;

import com.example.demo.model.Tour;
import com.example.demo.repository.IHaiTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HaiTourService implements IHaiTourService{
    @Autowired
    private IHaiTourRepository haiTourRepository;

    @Override
    public Page<Tour> findAll(Pageable pageable) {
        return haiTourRepository.findAllTour(pageable);
    }

    @Override
    public List<Tour> findAll() {
        return haiTourRepository.findAllTour();
    }

    @Override
    public Optional<Tour> findById(int id) {
        return haiTourRepository.findById(id);
    }

    @Override
    public void save(Tour tour) {
        haiTourRepository.save(tour);
    }

    @Override
    public void deleteById(int id) {
        haiTourRepository.deleteById(id);
    }

    @Override
    public Page<Tour> findAllByNameContaining(String name, Pageable pageable) {
        return haiTourRepository.findAllByNameContaining(name,pageable);
    }


}
