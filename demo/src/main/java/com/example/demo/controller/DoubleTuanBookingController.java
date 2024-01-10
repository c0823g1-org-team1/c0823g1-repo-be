package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Booking;
import com.example.demo.model.Tour;
import com.example.demo.service.IDoubleTuanBookingService;
import com.example.demo.service.ITuanAccountService;
import com.example.demo.service.ITuanTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/booking")
public class DoubleTuanBookingController {
    @Autowired
    private IDoubleTuanBookingService doubleTuanBookingService;

    @Autowired
    private ITuanAccountService accountService;

    @Autowired
    private ITuanTourService tuanTourService;

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("")
    private String home(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String nameSearch, RedirectAttributes redirectAttributes) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Booking> bookingPage = doubleTuanBookingService.getAllBookingPage(pageable, nameSearch);
        model.addAttribute("bookingPage", bookingPage);
        model.addAttribute("msg", 1);
        return "booking/managerBooking";
    }

    @GetMapping("add")
    private String add(Model model) {
        Account account = accountService.findById(1);
        Tour tour = tuanTourService.findById(1);
        Booking booking = new Booking();
        booking.setTour(tour);
        booking.setAccount(account);
        model.addAttribute("tour", tour);
        model.addAttribute("booking", booking);
        model.addAttribute("account", account);
        return "/booking/book";
    }

    @GetMapping("booking/addBooking")
    private String addBooking(Booking booking, RedirectAttributes redirectAttributes, Model model) {
        booking.setDate(LocalDateTime.now());
        doubleTuanBookingService.save(booking);
        Account account = accountService.findById(booking.getAccount().getId());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(account.getEmailClient());
        message.setSubject("Cảm ơn bạn đã sử dụng dịch vụ");
        message.setText("Cảm ơn bạn đã sử dụng dịch vụ");
        javaMailSender.send(message);
        redirectAttributes.addFlashAttribute("msg", 1);
        model.addAttribute("msg", 1);
        return "redirect:/home";
    }
}
