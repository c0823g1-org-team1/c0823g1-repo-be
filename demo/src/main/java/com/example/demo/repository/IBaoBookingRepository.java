package com.example.demo.repository;

import com.example.demo.model.Booking;
import com.example.demo.model.LocationTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBaoBookingRepository extends JpaRepository<Booking,Integer> {
    @Query(value = "select * from booking b where b.tour_id = :id",nativeQuery = true)
    Booking findBookingId (@Param("id") int id);
}
