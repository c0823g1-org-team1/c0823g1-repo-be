package com.example.demo.repository;

import com.example.demo.model.LocationTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationTourRepository extends JpaRepository<LocationTour,Integer> {
}
