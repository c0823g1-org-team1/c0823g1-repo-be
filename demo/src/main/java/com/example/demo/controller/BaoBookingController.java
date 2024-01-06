package com.example.demo.controller;
import com.example.demo.model.Booking;
import com.example.demo.model.LocationTour;
import com.example.demo.model.Tour;
import com.example.demo.service.IBaoBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class BaoBookingController {
    @Autowired
    private IBaoBookingService baoBookingService;

    @GetMapping
    public String getAll(Model model) {
        List<Tour> list = baoBookingService.getAll();
        model.addAttribute("tour", list);
        return "/home";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Tour tour = baoBookingService.findById(id);
        System.out.println(tour);
        List<LocationTour> location = baoBookingService.findLocation(tour.getId());
        Booking booking = baoBookingService.findBookingId(tour.getId());
        model.addAttribute("books",booking);
        model.addAttribute("locations",location);
        model.addAttribute("tours", tour);
        return "/detail";
    }
}
