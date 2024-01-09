package com.example.demo.service;

import com.example.demo.model.TourGuild;
import org.springframework.stereotype.Service;

@Service
public interface IHaiTourGuidService {
    TourGuild findById(Integer l);
}
