package com.example.demo.dto;

import com.example.demo.model.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private int id;
    private Date date;
    @NotBlank(message = "Không được để rỗng")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "Nhập Đúng Định Dạng")
    private String inforClient;
    private int adultNumber;
    private int childrenNumber;
    private boolean isDelete;
    private Account account;
    private Payment payment;
    private Price price;
    private Tour tour;
    private DetailPersonTour detailPersonTour;
}
