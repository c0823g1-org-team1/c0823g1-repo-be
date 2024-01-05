package com.example.demo.repository;

import com.example.demo.dto.TourDTO;
import com.example.demo.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBaoBookingRepository extends JpaRepository<Tour,Integer> {
//    @Query(value = "select r.id as id, r.name as name, r.quantity as quantity, r.description as description, img.img as img, img.type_img as typeImg\n" +
//            "from tour r join img img on r.id = img.tour_id\n" +
//            "where r.id = :id",nativeQuery = true)
//    TourDTO findIdTour(@Param("id") int id);

}
