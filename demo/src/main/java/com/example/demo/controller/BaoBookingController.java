package com.example.demo.controller;

import com.example.demo.dto.AccountDTO;
import com.example.demo.model.Account;
import com.example.demo.model.Booking;
import com.example.demo.model.LocationTour;
import com.example.demo.model.Tour;
import com.example.demo.service.IBaoBookingService;
import com.example.demo.service.ITuanAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Controller
@CrossOrigin(origins = "localhost:8080")
@RequestMapping("/home")
public class BaoBookingController {
    @Autowired
    private IBaoBookingService baoBookingService;
    @Autowired
    private ITuanAccountService tuanAccountService;

    @GetMapping
    public String getAll(Model model) {
        List<Tour> list = baoBookingService.getAll();
        Account account = new Account();
        model.addAttribute("account", account);
        model.addAttribute("tour", list);
        return "home";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Tour tour = baoBookingService.findById(id);
        Account account = tuanAccountService.findById(1);
        Booking booking = new Booking();
        tour.setCareAbout(tour.getCareAbout() + 1);
        baoBookingService.saveTour(tour);
        booking.setTour(tour);
        booking.setAccount(account);
        booking.setDate(LocalDateTime.now());
        booking.setId(5);
        List<LocationTour> location = baoBookingService.findLocation(tour.getId());
        model.addAttribute("locations", location);
        model.addAttribute("tours", tour);
        model.addAttribute("bookings", booking);
        model.addAttribute("account", account);
        return "detailTour";
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
                                   @RequestParam(name = "date", required = false) String date,
                                   @RequestParam(name = "TourLine", required = false, defaultValue = "0") String typeTour,
                                   @RequestParam(name = "savePrice", required = false, defaultValue = "0") String savePrice) throws ParseException {
        List<Tour> tours = baoBookingService.getAll();
        List<Tour> selectedTours = new ArrayList<>();
        LocalDate utilDate = null;
        try {
            utilDate = LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        int days = Integer.parseInt(day);
        int typeTours = Integer.parseInt(typeTour);
        int savePrices = Integer.parseInt(savePrice);
        for (Tour tour : tours) {
            LocalDate departureDate = tour.getDepartureDate();
            LocalDate endDate = tour.getEndDate();
            long durationInDays = ChronoUnit.DAYS.between(departureDate, endDate);
            if ((days == 3 && durationInDays == 3) || (days == 4 && durationInDays == 4)) {
                selectedTours.add(tour);
            }
        }
        List<Tour> save = new ArrayList<>();
        for (Tour tour : selectedTours) {
            if ((days == 3 && tour.getCareAbout() >= typeTours && utilDate != null) ||
                    (days == 4 && tour.getCareAbout() >= typeTours && utilDate != null) ||
                    (days == 3 && tour.getAdultPrice() >= savePrices && utilDate != null) ||
                    (days == 4 && tour.getCareAbout() >= savePrices && utilDate != null)) {
                save.addAll(baoBookingService.searchManyOption(utilDate));
                break;
            } else if (days == 3 || days == 4) {
                save.addAll(Collections.singleton(tour));
                break;
            }
        }
        for (Tour tour : tours) {
            if (tour.getAdultPrice() <= savePrices && utilDate == null && savePrices != 0) {
                save.addAll(baoBookingService.searchSavePrice(savePrices));
                break;
            } else if (tour.getCareAbout() >= typeTours && utilDate == null && typeTours != 0) {
                save.addAll(baoBookingService.searchHotTour(typeTours));
                break;
            } else {
                save.addAll(baoBookingService.searchManyOption(utilDate));
                break;
            }
        }
        model.addAttribute("tour", save);
        return "/search";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/accountuser")
    public String Account(Model model, Principal principal) {
        Account account = baoBookingService.getUserInforByUserName(principal.getName());
        model.addAttribute("account", account);
        return "/inforAccount";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/editAccount")
    public String updateAccount(@Valid @ModelAttribute("account") AccountDTO account, Model model,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println("OK");
        new AccountDTO().validate(account, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("account", account);
            return "inforAccount";
        }
        Account account1 = new Account();
        BeanUtils.copyProperties(account, account1);
        tuanAccountService.save(account1);
        return "redirect:/home/accountuser";
    }
}
