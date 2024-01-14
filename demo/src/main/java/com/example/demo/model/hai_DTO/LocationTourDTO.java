package com.example.demo.model.hai_DTO;

import com.example.demo.model.Tour;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationTourDTO implements Validator {
    private int id;
    @NotBlank(message = "Không được để trống")
    private String location;
    private Date date;
    private int typeTour;
    private boolean isDelete;
    @NotBlank(message = "Không được để trống")
    private String img;
    @NotBlank(message = "Không được để trống")
    private String descriptionLocation;
    @NotNull(message = "Không được để trống")
    private int tourDay;

    private Tour tour;

    @Override
    public boolean supports(Class<?> clazz) {
        return LocationTourDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LocationTourDTO locationTourDTO = (LocationTourDTO) target;
        int tourDay = locationTourDTO.tourDay;
        if (tourDay == 0){
            errors.rejectValue("tourDay","tourDay.fail");
        }
    }
}
