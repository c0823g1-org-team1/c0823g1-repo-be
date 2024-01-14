package com.example.demo.model.hai_DTO;

import com.example.demo.model.TourGuild;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourDTO implements Validator{
    private int id;
    @NotBlank(message = "Trường bắt buộc phải nhập")
    private String name;
    private boolean isDelete;
    @NotNull(message = "Trường bắt buộc phải nhập")
    @Min(value = 1,message = "Số lượng phải lớn hơn hoặc bằng 1")
    private int quantity;
    @NotBlank(message = "Trường bắt buộc phải nhập")
    private String image;


    @NotBlank(message = "Trường bắt buộc phải nhập")
    private String description;
    @NotNull(message = "Trường bắt buộc phải nhập")
    @Min(value = 1,message = "Giá phải lớn hơn hoặc bằng một")
    private int adultPrice;
    @NotNull(message = "Trường bắt buộc phải nhập")
    @Min(value = 1,message = "Giá phải lớn hơn hoặc bằng một")
    private int childrenPrice;
    private TourGuild tourGuild;
    @NotNull(message = "Trường bắt buộc phải nhập")
    @Future(message = "Ngày tạo tour phải sau ngày hôm nay")
    private LocalDate departureDate;
    @NotNull(message = "Trường bắt buộc phải nhập")
    @Future(message = "Ngày kết thúc tour phải sau ngày hôm nay")
    private LocalDate endDate;

    @Override
    public boolean supports(Class<?> clazz) {
        return TourDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TourDTO tourDTO = (TourDTO) target;
        LocalDate departureDate = tourDTO.departureDate;
        if (tourDTO.getDepartureDate() != null && tourDTO.getEndDate() != null){
            if (tourDTO.getDepartureDate().isAfter(tourDTO.getEndDate())){
                errors.rejectValue("departureDate","departureDate.fail");
            }
        }
        if (tourDTO.getTourGuild() == null){
            errors.rejectValue("tourGuild","tourGuild.fail");
        }
    }
}
