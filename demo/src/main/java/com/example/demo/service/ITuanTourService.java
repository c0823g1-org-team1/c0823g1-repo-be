package com.example.demo.service;

import com.example.demo.model.Tour;

import java.util.List;

public interface ITuanTourService {
    Tour findById(int id);

    List<Tour> getList();
}
