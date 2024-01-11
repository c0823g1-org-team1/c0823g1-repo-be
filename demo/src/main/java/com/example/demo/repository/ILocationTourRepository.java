package com.example.demo.repository;

import com.example.demo.model.LocationTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocationTourRepository extends JpaRepository<LocationTour,Integer> {
    @Query(value = "select * from location_tour where tour_id = :id",nativeQuery = true)
    List<LocationTour> findAllByTour_Id(int id);
}
