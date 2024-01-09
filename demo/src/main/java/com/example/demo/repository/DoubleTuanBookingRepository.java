package com.example.demo.repository;

import com.example.demo.model.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoubleTuanBookingRepository extends JpaRepository<Booking, Integer> {
    @Query(value = "SELECT * FROM booking where booking.is_delete = 0;", nativeQuery = true)
    Page<Booking> getAllBookingPage(Pageable pageable, @Param("name_account") String name_account);
}
