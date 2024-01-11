package com.example.demo.service;

import com.example.demo.repository.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private IAdminRepository adminRepository;

    @Override
    public Long priceDay() {
        return adminRepository.getPriceDay();
    }

    @Override
    public Long prideWeek() {
        return adminRepository.getPriceWeek();
    }

    @Override
    public Long priceMonth() {
        return adminRepository.getPriceMonth();
    }


}
