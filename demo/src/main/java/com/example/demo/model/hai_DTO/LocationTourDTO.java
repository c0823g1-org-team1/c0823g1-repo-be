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

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationTourDTO {
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
}
