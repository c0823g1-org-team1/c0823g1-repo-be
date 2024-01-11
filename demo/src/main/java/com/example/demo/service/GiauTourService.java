package com.example.demo.service;

import com.example.demo.model.TourGuild;
import com.example.demo.repository.IGiauTourGuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiauTourService implements IGiauTourService {
    @Autowired
    private IGiauTourGuideRepository iGiauTourGuideRepository;

    @Override
    public List<TourGuild> findAll() {
        return iGiauTourGuideRepository.findAll();
    }

    @Override
    public TourGuild findById(int id) {
        return iGiauTourGuideRepository.findById(id).get();
    }

    @Override
    public void save(TourGuild tourGuild) {
        iGiauTourGuideRepository.save(tourGuild);
    }

    @Override
    public Page<TourGuild> getList(Pageable pageable) {
        return iGiauTourGuideRepository.findAllTourGuild(pageable);
    }

    @Override
    public void delete(TourGuild tourGuild) {
        iGiauTourGuideRepository.delete(tourGuild);
    }

    @Override
    public Page<TourGuild> findByNameContaining(String name, Pageable pageable) {
        return iGiauTourGuideRepository.findByNameContaining(name, pageable);
    }
}
