package com.example.demo.controller;

import com.example.demo.model.LocationTour;
import com.example.demo.model.Tour;
import com.example.demo.service.IBaoBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        tour.setCareAbout(tour.getCareAbout() + 1);
        baoBookingService.saveTour(tour);
        List<LocationTour> location = baoBookingService.findLocation(tour.getId());
        model.addAttribute("locations", location);
        model.addAttribute("tours", tour);
        return "/detail";
    }

    @GetMapping("/hottour")
    public String searchTour(Model model) {
        List<Tour> list = baoBookingService.getAll();
        Collections.sort(list, Comparator.comparing(Tour::getCareAbout).reversed());
        Tour tour0 = list.get(0);
        Tour tour1 = list.get(1);
        Tour tour2 = list.get(2);
        List<Tour> list1 = new ArrayList<>();
        list1.add(tour0);
        list1.add(tour1);
        list1.add(tour2);
        List<Tour> list2 = new ArrayList<>();
        list2.addAll(list1);
        model.addAttribute("hotTour", list2);
        model.addAttribute("tour", list);
        return "/searchTour";
    }

    @PostMapping("/like")
    public String checkHeart(@RequestBody Map<String, String> payload, Model model) {
        String tourId = payload.get("tourId");
        int id = Integer.parseInt(tourId);
        Tour tour = baoBookingService.findById(id);
        tour.setView(tour.getView() + 1);
        baoBookingService.saveTour(tour);
        return "redirect:/home/hottour";
    }

    @GetMapping("/search/ascending")
    public String getToursAscending(Model model) {
        List<Tour> tours = baoBookingService.findAllByOrderByAdultPriceAsc();
        model.addAttribute("tour", tours);
        return "/searchTour";
    }

    @GetMapping("/search/descending")
    public String getToursDescending(Model model) {
        List<Tour> tours = baoBookingService.findAllByOrderByAdultPriceDesc();
        model.addAttribute("tour", tours);
        return "/searchTour";
    }

    @GetMapping("/searchTour")
    public String searchOptionTour(Model model, @RequestParam(name = "AmountDate", defaultValue = "0") String day,
                                   @RequestParam(name = "date", defaultValue = "2024-01-10") String date,
                                   @RequestParam(name = "TourLine", defaultValue = "0") String typeTour,
                                   @RequestParam(name = "savePrice", defaultValue = "0") String savePrice) throws ParseException {
        List<Tour> tours = baoBookingService.getAll();
        List<Tour> tours3d = new ArrayList<>();
        List<Tour> tours4d = new ArrayList<>();
        java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        java.sql.Date date1 = new java.sql.Date(utilDate.getTime());
        int days = Integer.parseInt(day);
        int typeTours = Integer.parseInt(typeTour);
        int savePrices = Integer.parseInt(savePrice);
        for (Tour tour : tours) {
            Date departureDate = tour.getDepartureDate();
            Date endDate =  tour.getEndDate();
            long durationInMillis = endDate.getTime() - departureDate.getTime();
            long durationInDays = durationInMillis / (24 * 60 * 60 * 1000);
            if (durationInDays == 3) {
                tours3d.add(tour);
            } else if (durationInDays == 4) {
                tours4d.add(tour);
            }
        }
        if (days == 3 & savePrices != 0 ) {
            for (Tour tour : tours3d) {
                if (tour.getCareAbout() >= typeTours ) {
                    List<Tour> save = baoBookingService.searchSaveMoney(date1);
                    model.addAttribute("tour", save);
                } else {
                    List<Tour> save = baoBookingService.searchSaveMoney( date1);
                    model.addAttribute("tour", save);
                }
            }
        } else if (days == 4 & savePrices != 0 ) {
            for (Tour tour : tours4d) {
                if (tour.getCareAbout() >= typeTours ) {
                    List<Tour> save = baoBookingService.searchSaveMoney( date1);
                    model.addAttribute("tour", save);
                } else {
                    List<Tour> save = baoBookingService.searchSaveMoney(date1);
                    model.addAttribute("tour", save);
                }
            }
        }
        if (days == 3 & typeTours != 0 ) {
            for (Tour tour : tours3d) {
                if (tour.getAdultPrice() >= savePrices ) {
                    List<Tour> save = baoBookingService.searchSaveMoney(date1);
                    model.addAttribute("tour", save);
                } else {
                    List<Tour> save = baoBookingService.searchSaveMoney( date1);
                    model.addAttribute("tour", save);
                }
            }
        } else if (days == 4 & typeTours != 0 ) {
            for (Tour tour : tours4d) { 
                if (tour.getCareAbout() >= savePrices ) {
                    List<Tour> save = baoBookingService.searchSaveMoney( date1);
                    model.addAttribute("tour", save);
                } else {
                    List<Tour> save = baoBookingService.searchSaveMoney(date1);
                    model.addAttribute("tour", save);
                }
            }
        }
        return "/search";
    }
}
