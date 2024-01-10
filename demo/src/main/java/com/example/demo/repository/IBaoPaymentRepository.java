package com.example.demo.repository;

import com.example.demo.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBaoPaymentRepository extends JpaRepository<Payment,Integer> {
    @Query (value = "select * from payment p where p.booking_id :id ",nativeQuery = true)
    Payment findIdPayment (@Param("id") int id);
}
