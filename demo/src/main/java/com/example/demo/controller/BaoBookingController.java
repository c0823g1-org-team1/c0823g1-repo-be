package com.example.demo.controller;

import com.example.demo.dto.TourDTO;
import com.example.demo.model.Img;
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
    public String getAll(Model model){
        List<Tour> list = baoBookingService.getAll();
        model.addAttribute("tour",list);
        return "/home";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable int id, Model model){
        Tour tour = baoBookingService.findById(id);
        List<Img> list = baoBookingService.img(tour.getId());
        int count = 0;
        for (Img img : list){
            model.addAttribute("img"+count,img.getTypeImg());
            count ++;
        }
        model.addAttribute("listImg",list);
          model.addAttribute("tours",tour);
    return "/detail";
    }
}
