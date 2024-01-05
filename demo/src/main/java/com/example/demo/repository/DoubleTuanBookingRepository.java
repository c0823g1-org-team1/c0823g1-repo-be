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
    @Query(value = "select b.* from booking b join account a on b.account_id = a.id join tour t on b.tour_id = t.id join price p on b.price_id = p.id join detail_persont_tour dpt on b.id = dpt.booking_id join payment pm  on b.id = pm.booking_id where a.name_account like concat ('%', :name_account , '%') and b.is_delete = 0", nativeQuery = true, countQuery = "select count(*) from(select b.* from booking b join account a on b.account_id = a.id join tour t on b.tour_id = t.id join price p on b.price_id = p.id join detail_persont_tour dpt on b.id = dpt.booking_id join payment pm  on b.id = pm.booking_id where a.name_account like concat ('%', :name_account , '%') and b.is_delete = 0) temp")
    Page<Booking> getAllBookingPage(Pageable pageable, @Param("name_account") String name_account);
}
