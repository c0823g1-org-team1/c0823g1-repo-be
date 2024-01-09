package com.example.demo.repository;

import com.example.demo.model.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IHaiTourRepository extends JpaRepository<Tour,Integer> {
    @Query(value = "select * from tour where is_delete = 0",nativeQuery = true)
    Page<Tour> findAllTour(Pageable pageable);
    Page<Tour> findAllByNameContaining(String name,Pageable pageable);
}
