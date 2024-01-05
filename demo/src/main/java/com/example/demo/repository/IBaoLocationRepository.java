package com.example.demo.repository;

import com.example.demo.model.Img;
import com.example.demo.model.LocationTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBaoLocationRepository extends JpaRepository<LocationTour,Integer> {
    @Query(value = "select * from location_tour lt where lt.tour_id = :id",nativeQuery = true)
    List<LocationTour> findLocation (@Param("id") int id);
}
