package com.example.demo.service;

import com.example.demo.model.TourGuild;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGiauTourService {
    List<TourGuild> findAll();

    TourGuild findById(int id);

    void save(TourGuild tourGuild);

    Page<TourGuild> getList(Pageable pageable);

    void delete(TourGuild tourGuild);

    Page<TourGuild> findByNameContaining(String name, Pageable pageable);
}
