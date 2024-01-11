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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String showTour(@PageableDefault(value = 4) Pageable pageable,
                           Model model) {
        Page<Tour> tourPage = haiTourService.findAll(pageable);
        model.addAttribute("tours", tourPage);
        model.addAttribute("df", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return "/admin_manager/display_tour";
    }

    @GetMapping("/{id}/detail")
    public String showDetailTour(@PathVariable int id,
                                 Model model) {
        Optional<Tour> tour = haiTourService.findById(id);
        if (tour.isPresent()) {
            model.addAttribute("tour", tour.get());
            model.addAttribute("df", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            LocationTourDTO locationTourDTO = new LocationTourDTO();
            locationTourDTO.setTour(tour.get());
            model.addAttribute("location", locationTourDTO);
            List<LocationTour> locationTours = haiLocationTourService.findAll();
            model.addAttribute("locationTour", locationTours);
            return "admin_manager/detail_tour";
        }
        return "redirect:/admin_manager";
    }

    @GetMapping("/{id}/edit")
    public String editTour(@PathVariable int id,
                           Model model) {
        model.addAttribute("tour", haiTourService.findById(id));
        return "/admin_manager/edit_tour";
    }

    @PostMapping("/{id}/edit")
    public String saveTour(@Valid @ModelAttribute("tour") TourDTO tourDTO, BindingResult bindingResult,
                           @PathVariable int id,
                           RedirectAttributes redirectAttributes,
                           Model model) {
        new TourDTO().validate(tourDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("tour", tourDTO);
            return "/admin_manager/edit_tour";
        }
        for (Tour t : haiTourService.findAll()) {
            if ((tourDTO.getDepartureDate().isAfter(t.getDepartureDate()) && tourDTO.getDepartureDate().isBefore(t.getEndDate().plusDays(1)))
                    || (tourDTO.getEndDate().isAfter(t.getDepartureDate().minusDays(1)) && tourDTO.getEndDate().isBefore(t.getEndDate()))) {
                if (t.getTourGuild() == tourDTO.getTourGuild()) {
                    model.addAttribute("mess", "Hướng dẫn viên " + t.getTourGuild().getName() + " có lịch trong thời gian " + t.getDepartureDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " đến " + t.getEndDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " ! Vui lòng chọn HDV khác");
                    return "/admin_manager/edit_tour";
                }
            }

        }
        Optional<Tour> tour = haiTourService.findById(id);
        BeanUtils.copyProperties(tourDTO, tour);
        haiTourService.save(tour.get());
        redirectAttributes.addFlashAttribute("message", "Sửa thành công");
        return "redirect:/admin_manager/" + tour.get().getId() + "/detail_tour";

    }

    @GetMapping("/create")
    public String createTour(Model model) {
        model.addAttribute("tour", new TourDTO());
        return "/admin_manager/edit_tour";
    }

    @PostMapping("/create")
    public String saveTour(@Valid @ModelAttribute("tour") TourDTO tourDTO,
                           BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        System.out.println(tourDTO.toString());
        new TourDTO().validate(tourDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("tour", tourDTO);
            return "/admin_manager/edit_tour";
        }
        for (Tour t : haiTourService.findAll()) {
            if ((tourDTO.getDepartureDate().isAfter(t.getDepartureDate()) && tourDTO.getDepartureDate().isBefore(t.getEndDate().plusDays(1)))
                    || (tourDTO.getEndDate().isAfter(t.getDepartureDate().minusDays(1)) && tourDTO.getEndDate().isBefore(t.getEndDate()))) {
                if (t.getTourGuild() == tourDTO.getTourGuild()) {
                    model.addAttribute("mess", "Hướng dẫn viên " + t.getTourGuild().getName() + " có lịch trong thời gian " + t.getDepartureDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " đến " + t.getEndDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " ! Vui lòng chọn HDV khác");
                    return "/admin_manager/edit_tour";
                }
            }

        }
        if (tourDTO.getChildrenPrice() > tourDTO.getAdultPrice()) {
            model.addAttribute("mess1", "Giá của trẻ em phải nhỏ hơn hoặc bằng giá cho người lớn");
            return "/admin_manager/edit_tour";
        }
        Tour tour = new Tour();
        BeanUtils.copyProperties(tourDTO, tour);
        haiTourService.save(tour);
        model.addAttribute("tour", tour);
        model.addAttribute("df", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return "redirect:/admin_manager/" + tour.getId() + "/detail_tour";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("idDelete") int id) {
        Optional<Tour> tour = haiTourService.findById(id);
        tour.get().setDelete(true);
        haiTourService.save(tour.get());
        return "redirect:/admin_manager/display_tour";
    }

    @PostMapping("/search")
    public String search(@RequestParam("name-search") String name,
                         @PageableDefault(value = 3) Pageable pageable,
                         Model model) {
        Page<Tour> tours = haiTourService.findAllByNameContaining(name, pageable);
        model.addAttribute("df", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        model.addAttribute("tours", tours);
        return "/admin_manager/display_tour";
    }
//    @GetMapping("{id}/detail/location")
//    public ResponseEntity<List<LocationTour>> findAllById(@PathVariable int id){
//        return new ResponseEntity<>(haiLocationTourService.findAllById(id), HttpStatus.OK);
//    }

    @PostMapping("/save-location")
    public String saveLocation(@Valid @ModelAttribute("location") LocationTourDTO locationTourDTO,
                               BindingResult bindingResult, Model model) {

        if (bindingResult.hasFieldErrors()) {
            Optional<Tour> tour = haiTourService.findById(locationTourDTO.getTour().getId());
            model.addAttribute("tour", tour.get());
            model.addAttribute("df", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            model.addAttribute("location", locationTourDTO);
            model.addAttribute("messVaild", "Chưa thêm được điểm đến");
            return "/admin_manager/detail_tour";
        }
        LocationTour locationTour = new LocationTour();
        BeanUtils.copyProperties(locationTourDTO, locationTour);
        haiLocationTourService.save(locationTour);
        model.addAttribute("df", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        model.addAttribute("location", new LocationTourDTO());
        Optional<Tour> tour = haiTourService.findById(locationTourDTO.getTour().getId());
        model.addAttribute("tour", tour.get());
        List<LocationTour> locationTours = haiLocationTourService.findAll();
        model.addAttribute("locationTour", locationTours);
        return "redirect:/admin_manager/" + tour.get().getId() + "/detail_tour";
    }

    @PostMapping("/edit-location")
    public String showForm(@RequestParam("id-edit") int id,
                           Model model) {
        Optional<LocationTour> locationTour = haiLocationTourService.findById(id);
        Optional<Tour> tour = haiTourService.findById(locationTour.get().getTour().getId());
        model.addAttribute("location", locationTour.get());
        model.addAttribute("tour", tour.get());
        model.addAttribute("df", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return "/admin_manager/detail_tour";
    }

    @PostMapping("/delete-location")
    public String showDetail(@RequestParam("idDelete") int id,
                             Model model,
                             RedirectAttributes redirectAttributes) {
        Optional<LocationTour> locationTour = haiLocationTourService.findById(id);
        haiLocationTourService.delete(locationTour.get());
        Optional<Tour> tour = haiTourService.findById(locationTour.get().getTour().getId());
        model.addAttribute("tour", tour.get());
        model.addAttribute("df", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocationTourDTO locationTourDTO = new LocationTourDTO();
        locationTourDTO.setTour(tour.get());
        List<LocationTour> locationTours = haiLocationTourService.findAll();
        model.addAttribute("locationTour", locationTours);
        model.addAttribute("location", locationTourDTO);
        redirectAttributes.addFlashAttribute("msg", 1);
        return "redirect:/admin_manager/" + tour.get().getId() + "/detail_tour";
    }
}
