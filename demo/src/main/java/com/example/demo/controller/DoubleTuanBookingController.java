package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.service.IDoubleTuanBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/booking")
@CrossOrigin("http://localhost:8080/")
public class DoubleTuanBookingController {
    @Autowired
    private IDoubleTuanBookingService doubleTuanBookingService;
    @GetMapping("")
    private String home(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String nameSearch) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("date").ascending());
        Page<Booking> bookingPage = doubleTuanBookingService.getAllBookingPage(pageable, nameSearch);
        model.addAttribute("bookingPage", bookingPage);
        return "booking/managerBooking";
    }
}
