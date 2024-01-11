package com.example.demo.repository;

import com.example.demo.model.TourGuild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHaiTourGuidRepository extends JpaRepository<TourGuild,Integer> {
    @Query(value = "select * from tour_guild where is_delete = false",nativeQuery = true)
    List<TourGuild> findAllTourGuid();
}
