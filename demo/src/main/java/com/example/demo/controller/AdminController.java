package com.example.demo.controller;

import com.example.demo.service.IAdminService;
import com.example.demo.service.IDoubleTuanBookingService;
import com.example.demo.service.IHaiTourService;
import com.example.demo.service.ITuanAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private ITuanAccountService tuanAccountService;
    @Autowired
    private IDoubleTuanBookingService tuanBookingService;
    @Autowired
    private IHaiTourService haiTourService;
    @Autowired
    private IAdminService adminService;

    @GetMapping
    private String home(Model model) {
        model.addAttribute("priceDay", adminService.priceDay());
        model.addAttribute("priceWeek", adminService.prideWeek());
        model.addAttribute("priceMonth", adminService.priceMonth());
        return "/admin_manager/home";
    }

}
