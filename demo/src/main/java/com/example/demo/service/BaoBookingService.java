package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BaoBookingService implements IBaoBookingService {
    @Autowired
    private IBaoTourRepository baoTourRepository;
    @Autowired
    private IBaoLocationRepository baoLocationRepository;
    @Autowired
    private IBaoPaymentRepository baoPaymentRepository;
    @Autowired
    private IBaoBookingRepository baoBookingRepository;
    @Autowired
    private TuanAccountRepository tuanAccountService;

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
    public List<Tour> searchManyOption(LocalDate date) {
        return baoTourRepository.searchManyOption(date);
    }

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

    @Override
    public List<Tour> findIdTourToIdTourGuild(int id) {
        return baoTourRepository.findIdTourToIdTourGuild(id);
    }

    @Override
    public Account getUserInforByUserName(String name) {
        return tuanAccountService.getUserInforByUserName('%'+name+'%');
    }


}