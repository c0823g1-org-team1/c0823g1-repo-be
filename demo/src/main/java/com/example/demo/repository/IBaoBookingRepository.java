package com.example.demo.repository;

import com.example.demo.dto.RankDTO;
import com.example.demo.model.Booking;
import com.example.demo.model.LocationTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBaoBookingRepository extends JpaRepository<Booking,Integer> {
    @Query(value = "select * from booking b where b.tour_id = :id",nativeQuery = true)
    Booking findBookingId (@Param("id") int id);

    @Query(value = "select b.adult_number,b.children_number, b.date," +
            " p.status,t.adult_price,t.children_price,t.name as nameTour," +
            "tg.name as nameTourGuild,t.departure_date as departureDate,t.end_date as endDate\n" +
            "from account a \n" +
            "join booking b on a.id = b.account_id \n" +
            "join payment p on p.booking_id = b.id \n" +
            "join tour t on t.id = b.tour_id\n" +
            "join tour_guild tg on  tg.id = t.tour_guild_id\n" +
            "where a.id = :id and p.status = 1 ;",nativeQuery = true)
    List<RankDTO> showBookingUser(@Param("id") int id);
}
