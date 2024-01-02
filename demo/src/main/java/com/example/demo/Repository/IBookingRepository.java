package com.example.demo.Repository;

import com.example.demo.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingRepository extends JpaRepository<Booking,Integer> {
}
