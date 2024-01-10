package com.example.demo.service;

import com.example.demo.model.Tour;
import com.example.demo.repository.ITuanTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuanTourService implements ITuanTourService {

    @Autowired
    private ITuanTourRepository tuanTourRepository;

    @Override
    public Tour findById(int id) {
        return tuanTourRepository.findById(id).get();
    }

    @Override
    public List<Tour> getList() {
        return tuanTourRepository.findAll();
    }
}
