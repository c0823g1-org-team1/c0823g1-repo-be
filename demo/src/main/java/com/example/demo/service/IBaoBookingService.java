package com.example.demo.service;

import com.example.demo.dto.TourDTO;
import com.example.demo.model.Img;
import com.example.demo.model.Tour;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBaoBookingService {
    List<Tour> getAll();
    Tour findById(int id);
    List<Img> img(int id);

}