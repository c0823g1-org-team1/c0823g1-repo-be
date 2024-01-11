package com.example.demo.repository;

import com.example.demo.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface IAdminRepository extends JpaRepository<Booking, Integer> {
    @Query(value = "SELECT SUM(b.adult_number * t.adult_price + b.children_number * t.children_price) AS tong_tien FROM booking b JOIN tour t ON b.tour_id = t.id JOIN payment p ON b.id = p.booking_id WHERE b.is_delete = 0 AND DATE(b.date) = CURDATE() AND p.status = 1", nativeQuery = true)
    Long getPriceDay();

    @Query(value = "SELECT SUM(b.adult_number * t.adult_price + b.children_number * t.children_price) AS tong_tien FROM booking b JOIN tour t ON b.tour_id = t.id JOIN payment p ON b.id = p.booking_id WHERE b.is_delete = 0 AND YEARWEEK(b.date, 1) = YEARWEEK(CURDATE(), 1) AND p.status = 1", nativeQuery = true)
    Long getPriceWeek();

    @Query(value = "SELECT SUM(b.adult_number * t.adult_price + b.children_number * t.children_price) AS tong_tien FROM booking b JOIN tour t ON b.tour_id = t.id JOIN payment p ON b.id = p.booking_id WHERE b.is_delete = 0 AND MONTH(b.date) = MONTH(CURDATE()) AND YEAR(b.date) = YEAR(CURDATE()) AND p.status = 1", nativeQuery = true)
    Long getPriceMonth();
}
