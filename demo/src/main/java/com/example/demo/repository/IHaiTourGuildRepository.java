package com.example.demo.repository;

import com.example.demo.model.TourGuild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHaiTourGuildRepository extends JpaRepository<TourGuild,Integer> {
}
