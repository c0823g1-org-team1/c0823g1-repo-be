package com.example.demo.controller;

import com.example.demo.service.IDoubleTuanBookingService;
import com.example.demo.service.IHaiTourService;
import com.example.demo.service.ITuanAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private ITuanAccountService tuanAccountService;
    @Autowired
    private IDoubleTuanBookingService tuanBookingService;
    @Autowired
    private IHaiTourService haiTourService;

    @GetMapping
    private String home() {
        return "/admin_manager/home";
    }
}
