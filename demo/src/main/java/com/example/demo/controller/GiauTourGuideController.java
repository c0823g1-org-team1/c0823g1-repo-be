package com.example.demo.controller;

import com.example.demo.dto.TourGuildDTO;
import com.example.demo.model.TourGuild;
import com.example.demo.service.IGiauTourService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tourGuide")
public class  GiauTourGuideController {
    @Autowired
    private IGiauTourService iGiauTourService;

    @GetMapping("")
    public String show(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<TourGuild> tourGuilds = iGiauTourService.getList(pageable);
        model.addAttribute("tourGuide", tourGuilds);
        return "giau/list-tour-guide";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        TourGuild tourGuild = iGiauTourService.findById(id);
        tourGuild.setDelete(true);
        iGiauTourService.save(tourGuild);
        return "redirect:/tourGuide";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("tourGuide", new TourGuildDTO());
        return "giau/add-tour-guide";
    }

    @GetMapping("edit/{id}")
    public String showFormEdit(Model model, @PathVariable int id) {
        model.addAttribute("tourGuide", iGiauTourService.findById(id));
        return "giau/edit-tour-guide";
    }

    @GetMapping("edit/editGuide")
    public String saveTour(@Valid @ModelAttribute("tourGuide") TourGuildDTO tourGuildDTO, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Model model) {
        new TourGuildDTO().validate(tourGuildDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("tourGuide", tourGuildDTO);
            return "giau/edit-tour-guide";
        }
        TourGuild tourGuild = new TourGuild();
        BeanUtils.copyProperties(tourGuildDTO, tourGuild);
        iGiauTourService.save(tourGuild);
        redirectAttributes.addFlashAttribute("msg", 1);
        return "redirect:/tourGuide";

    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("tourGuide") TourGuildDTO tourGuildDTO,
                      BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new TourGuildDTO().validate(tourGuildDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("tourGuildDTO", tourGuildDTO);
            return "giau/add-tour-guide";
        }
        TourGuild tourGuild = new TourGuild();
        BeanUtils.copyProperties(tourGuildDTO, tourGuild);
        iGiauTourService.save(tourGuild);
        redirectAttributes.addFlashAttribute("msg", 2);
        return "redirect:/tourGuide";
    }

    @PostMapping("/search")
    public String search(@RequestParam("name-search") String name,
                         @PageableDefault(value = 3) Pageable pageable,
                         Model model) {
        Page<TourGuild> tourGuilds = iGiauTourService.findByNameContaining(name, pageable);
        model.addAttribute("tourGuide", tourGuilds);
        return "giau/list-tour-guide";
    }
}
