package com.example.demo.service;


import com.example.demo.dto.RankDTO;
import com.example.demo.model.*;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IBaoBookingService {
    List<Tour> getAll();

    Tour findById(int id);


    List<LocationTour> findLocation(int id);

    void saveTour(Tour tour);

    //    Page<Tour> getAllTour(int price, Pageable pageable);
    List<Tour> findAllByOrderByAdultPriceAsc();

    List<Tour> findAllByOrderByAdultPriceDesc();

    List<Tour> searchManyOption(LocalDate date);

    List<Tour> searchHotTour(int careAbout);

    List<Tour> searchSavePrice(int adultPrice);

    void savePayment(Payment payment);

    Payment findIdPayment(int id);

    Booking save(Booking booking);

    List<Tour> findIdTourToIdTourGuild(int id);

    Account getUserInforByUserName(String name);

    List<RankDTO> showBookingUser(int id);
}