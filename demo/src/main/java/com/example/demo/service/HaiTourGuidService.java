package com.example.demo.service;

import com.example.demo.model.TourGuild;
import com.example.demo.repository.IHaiTourGuidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HaiTourGuidService implements IHaiTourGuidService{
    @Autowired
    private IHaiTourGuidRepository haiTourGuidRepository;
    @Override
    public TourGuild findById(Integer l) {
        return haiTourGuidRepository.findById(l).get();
    }
}
