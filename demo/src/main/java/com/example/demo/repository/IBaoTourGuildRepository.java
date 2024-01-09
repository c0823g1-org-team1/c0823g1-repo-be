package com.example.demo.repository;

import com.example.demo.model.TourGuild;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBaoTourGuildRepository extends JpaRepository<TourGuild,Integer> {
}
