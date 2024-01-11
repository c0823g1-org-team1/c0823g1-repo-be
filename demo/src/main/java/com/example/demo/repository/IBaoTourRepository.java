package com.example.demo.repository;

import com.example.demo.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IBaoTourRepository extends JpaRepository<Tour, Integer> {
    //    @Query(value = "select r.id as id, r.name as name, r.quantity as quantity, r.description as description, img.img as img, img.type_img as typeImg\n" +
//            "from tour r join img img on r.id = img.tour_id\n" +
//            "where r.id = :id",nativeQuery = true)
//    TourDTO findIdTour(@Param("id") int id);
//    like concat('%', :content ,'%')"

    List<Tour> findAllByOrderByAdultPriceAsc();
    List<Tour> findAllByOrderByAdultPriceDesc();
    @Query(value = "select * from tour t where t.adult_price <= 500000 and t.departure_date = :date ",nativeQuery = true)
    List<Tour> searchManyOption (@Param("date") LocalDate date);

    @Query(value = "select * from tour t where t.care_about >= :cartAbout",nativeQuery = true)
    List<Tour> searchHotTour(@Param("cartAbout") int careAbout);

    @Query(value = "select * from tour t where t.adult_price <= :adultPrice",nativeQuery = true)
    List<Tour> searchSavePrice(@Param("adultPrice") int adultPrice);

    @Query (value = "select  * from tour t where t.tour_guild_id = :id",nativeQuery = true)
    List<Tour> findIdTourToIdTourGuild(@Param("id") int id);
}
