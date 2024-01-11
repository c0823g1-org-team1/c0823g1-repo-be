package com.example.demo.controller;

import com.example.demo.model.LocationTour;
import com.example.demo.model.Tour;
import com.example.demo.model.TourGuild;
import com.example.demo.model.hai_DTO.LocationTourDTO;
import com.example.demo.model.hai_DTO.TourDTO;
import com.example.demo.repository.IHaiTourGuidRepository;
import com.example.demo.service.IHaiLocationTourService;
import com.example.demo.service.IHaiTourService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tours")
public class HaiTourController {

    @Autowired
    private IHaiTourService haiTourService;
    @Autowired
    private IHaiLocationTourService haiLocationTourService;
    @Autowired
    private IHaiTourGuidRepository haiTourGuidRepository;

//    @ModelAttribute("locationTour")
//    public List<LocationTour> locationTourList() {
//        return haiLocationTourService.findAll();
//    }

    @ModelAttribute("tourGuild")
    public List<TourGuild> tourGuilds() {
        return haiTourGuidRepository.findAll();
    }
    @ModelAttribute("tours")
    public List<Tour> tours() {
        return haiTourService.findAll();
    }

    @GetMapping
    public String showTour(@PageableDefault(value = 3) Pageable pageable,
                           Model model) {
        Page<Tour> tourPage = haiTourService.findAll(pageable);
        model.addAttribute("tours", tourPage);
        model.addAttribute("df", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return "/hai_tour/home-tour";
    }

    @GetMapping("/{id}/detail")
    public String showDetailTour(@PathVariable int id,
                                 Model model) {
        Optional<Tour> tour = haiTourService.findById(id);
        if (tour.isPresent()){
            model.addAttribute("tour", tour.get());
            model.addAttribute("df", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            LocationTourDTO locationTourDTO = new LocationTourDTO();
            locationTourDTO.setTour(tour.get());
            model.addAttribute("location",locationTourDTO);
            List<LocationTour> locationTours = haiLocationTourService.findAll();
            model.addAttribute("locationTour",locationTours);
            return "/hai_tour/detail";
        }
        return "redirect:/tours";
    }

    @GetMapping("/{id}/edit")
    public String editTour(@PathVariable int id,
                           Model model) {
        model.addAttribute("tour", haiTourService.findById(id));
        return "/hai_tour/edit";
    }

    @PostMapping("/{id}/edit")
    public String saveTour(@Valid @ModelAttribute("tour") TourDTO tourDTO, BindingResult bindingResult,
                           @PathVariable int id,
                           RedirectAttributes redirectAttributes,
                           Model model) {
        new TourDTO().validate(tourDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("tour", tourDTO);
            return "/hai_tour/edit";
        }
        for (Tour t : haiTourService.findAll()) {
            if ((tourDTO.getDepartureDate().isAfter(t.getDepartureDate()) && tourDTO.getDepartureDate().isBefore(t.getEndDate().plusDays(1)))
                    || (tourDTO.getEndDate().isAfter(t.getDepartureDate().minusDays(1)) && tourDTO.getEndDate().isBefore(t.getEndDate()))) {
                if (t.getTourGuild() == tourDTO.getTourGuild()) {
                    model.addAttribute("mess", "Hướng dẫn viên " +t.getTourGuild().getName()+" có lịch trong thời gian "+t.getDepartureDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +" đến "+t.getEndDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+ " ! Vui lòng chọn HDV khác");
                    return "/hai_tour/edit";
                }
            }

        }
        Optional<Tour> tour = haiTourService.findById(id);
        BeanUtils.copyProperties(tourDTO, tour);
        haiTourService.save(tour.get());
        redirectAttributes.addFlashAttribute("message", "Sửa thành công");
        return "redirect:/tours/"+tour.get().getId()+"/detail";

    }

    @GetMapping("/create")
    public String createTour(Model model) {
        model.addAttribute("tour", new TourDTO());
        return "/hai_tour/edit";
    }

    @PostMapping("/create")
    public String saveTour(@Valid @ModelAttribute("tour") TourDTO tourDTO,
                           BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        System.out.println(tourDTO.toString());
        new TourDTO().validate(tourDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("tour", tourDTO);
            return "/hai_tour/edit";
        }
        for (Tour t : haiTourService.findAll()) {
            if ((tourDTO.getDepartureDate().isAfter(t.getDepartureDate()) && tourDTO.getDepartureDate().isBefore(t.getEndDate().plusDays(1)))
                    || (tourDTO.getEndDate().isAfter(t.getDepartureDate().minusDays(1)) && tourDTO.getEndDate().isBefore(t.getEndDate()))) {
                if (t.getTourGuild() == tourDTO.getTourGuild()) {
                    model.addAttribute("mess", "Hướng dẫn viên " +t.getTourGuild().getName()+" có lịch trong thời gian "+t.getDepartureDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +" đến "+t.getEndDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+ " ! Vui lòng chọn HDV khác");
                    return "/hai_tour/edit";
                }
            }

        }
        if (tourDTO.getChildrenPrice()>tourDTO.getAdultPrice()){
            model.addAttribute("mess1", "Giá của trẻ em phải nhỏ hơn hoặc bằng giá cho người lớn");
            return "/hai_tour/edit";
        }
        Tour tour = new Tour();
        BeanUtils.copyProperties(tourDTO, tour);
        haiTourService.save(tour);
        model.addAttribute("tour",tour);
        model.addAttribute("df", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return "redirect:/tours/"+tour.getId()+"/detail";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("idDelete") int id) {
        Optional<Tour> tour = haiTourService.findById(id);
        tour.get().setDelete(true);
        haiTourService.save(tour.get());
        return "redirect:/tours";
    }

    @PostMapping("/search")
    public String search(@RequestParam("name-search") String name,
                         @PageableDefault(value = 3) Pageable pageable,
                         Model model) {
        Page<Tour> tours = haiTourService.findAllByNameContaining(name, pageable);
        model.addAttribute("df", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        model.addAttribute("tours", tours);
        return "/hai_tour/home-tour";
    }
//    @GetMapping("{id}/detail/location")
//    public ResponseEntity<List<LocationTour>> findAllById(@PathVariable int id){
//        return new ResponseEntity<>(haiLocationTourService.findAllById(id), HttpStatus.OK);
//    }

    @PostMapping("/save-location")
    public String saveLocation(@Valid @ModelAttribute("location") LocationTourDTO locationTourDTO,
                               BindingResult bindingResult,Model model ){

        if (bindingResult.hasFieldErrors()) {
            Optional<Tour> tour = haiTourService.findById(locationTourDTO.getTour().getId());
            model.addAttribute("tour",tour.get());
            model.addAttribute("df", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            model.addAttribute("location", locationTourDTO);
            model.addAttribute("messVaild","Chưa thêm được điểm đến");
            return "/hai_tour/detail";
        }
        LocationTour locationTour = new LocationTour();
        BeanUtils.copyProperties(locationTourDTO,locationTour);
        haiLocationTourService.save(locationTour);
        model.addAttribute("df", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        model.addAttribute("location",new LocationTourDTO());
        Optional<Tour> tour = haiTourService.findById(locationTourDTO.getTour().getId());
        model.addAttribute("tour",tour.get());
        List<LocationTour> locationTours = haiLocationTourService.findAll();
        model.addAttribute("locationTour",locationTours);
        return "redirect:/tours/"+tour.get().getId()+"/detail";
    }
    @PostMapping("/edit-location")
    public String showForm(@RequestParam("id-edit") int id,
                           Model model){
        Optional<LocationTour> locationTour = haiLocationTourService.findById(id);
        Optional<Tour> tour = haiTourService.findById(locationTour.get().getTour().getId());
        model.addAttribute("location",locationTour.get());
        model.addAttribute("tour",tour.get());
        model.addAttribute("df", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return "/hai_tour/detail";
    }
    @PostMapping("/delete-location")
    public String showDetail(@RequestParam("idDelete") int id,
                             Model model,
                             RedirectAttributes redirectAttributes){
        Optional<LocationTour> locationTour = haiLocationTourService.findById(id);
        haiLocationTourService.delete(locationTour.get());
        Optional<Tour> tour = haiTourService.findById(locationTour.get().getTour().getId());
        model.addAttribute("tour", tour.get());
        model.addAttribute("df", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocationTourDTO locationTourDTO = new LocationTourDTO();
        locationTourDTO.setTour(tour.get());
        List<LocationTour> locationTours = haiLocationTourService.findAll();
        model.addAttribute("locationTour",locationTours);
        model.addAttribute("location",locationTourDTO);
        redirectAttributes.addFlashAttribute("msg",1);
        return "redirect:/tours/"+tour.get().getId()+"/detail";
    }
}
