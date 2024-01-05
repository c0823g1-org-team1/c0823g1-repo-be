package com.example.demo.repository;

import com.example.demo.model.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBaoImgRepository extends JpaRepository<Img,Integer> {
    @Query(value = "select * from img img where img.tour_id = :id",nativeQuery = true)
    List<Img> img(@Param("id") int id);
}
