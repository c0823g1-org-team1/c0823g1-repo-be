package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.model.LocationTour;
import com.example.demo.model.Tour;
import com.example.demo.repository.IBaoBookingRepository;
import com.example.demo.repository.IBaoTourRepository;

import com.example.demo.repository.IBaoLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BaoBookingService implements IBaoBookingService {
    @Autowired
    private IBaoTourRepository baoTourRepository;
    @Autowired
    private IBaoLocationRepository baoLocationRepository;
    @Autowired
    private IBaoBookingRepository baoBookingRepository;
    @Override
    public List<Tour> getAll() {
        return baoTourRepository.findAll();
    }

    @Override
    public Tour findById(int id) {
        return baoTourRepository.findById(id).get();
    }

    @Override
    public List<LocationTour> findLocation(int id) {
        return baoLocationRepository.findLocation(id);
    }

    @Override
    public void saveTour(Tour tour) {
        baoTourRepository.save(tour);
    }

    @Override
    public List<Tour> findAllByOrderByAdultPriceAsc() {
        return baoTourRepository.findAllByOrderByAdultPriceAsc();
    }

    @Override
    public List<Tour> findAllByOrderByAdultPriceDesc() {
        return baoTourRepository.findAllByOrderByAdultPriceDesc();
    }

    @Override
    public List<Tour> searchSaveMoney(Date date) {
        return baoTourRepository.searchSaveMoney(date);
    }

<<<<<<< HEAD
}
=======
    @Override
    public List<Tour> searchHotTour(int careAbout) {
        return baoTourRepository.searchHotTour(careAbout);
    }

    @Override
    public List<Tour> searchSavePrice(int adultPrice) {
        return baoTourRepository.searchSavePrice(adultPrice);
    }

    @Override
    public void savePayment(Payment payment) {
        baoPaymentRepository.save(payment);
    }

    @Override
    public Payment findIdPayment(int id) {
        return baoPaymentRepository.findIdPayment(id);
    }

    @Override
    public Booking save(Booking booking) {
        return baoBookingRepository.save(booking);
    }


}
>>>>>>> 528a61ba7cc1424ca93960a5d0620ddb65ca55ab
