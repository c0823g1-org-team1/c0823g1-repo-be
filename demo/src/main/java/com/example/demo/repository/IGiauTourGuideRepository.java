package com.example.demo.repository;

import com.example.demo.model.TourGuild;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGiauTourGuideRepository extends JpaRepository<TourGuild, Integer> {
    @Query(value = "select * from tour_guild where is_delete = false", nativeQuery = true)
    Page<TourGuild> findAllTourGuild(Pageable pageable);
    Page<TourGuild> findByNameContaining(String name, Pageable pageable);
}
