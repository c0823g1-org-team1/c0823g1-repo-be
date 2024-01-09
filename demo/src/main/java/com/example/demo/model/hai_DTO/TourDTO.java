package com.example.demo.model.hai_DTO;

import jakarta.validation.constraints.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
public class TourDTO implements Validator{
    private int id;
    @NotBlank(message = "Trường bắt buộc phải nhập")
    private String name;
    private boolean isDelete;
    @NotNull(message = "Trường bắt buộc phải nhập")
    @Min(value = 1,message = "Số lượng phải lớn hơn hoặc bằng 1")
    private int quantity;
    private String image;
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }


    @NotBlank(message = "Trường bắt buộc phải nhập")
    private String description;
    @NotNull(message = "Trường bắt buộc phải nhập")
    @Min(value = 1,message = "Giá phải lớn hơn hoặc bằng một")
    private int adultPrice;
    @NotNull(message = "Trường bắt buộc phải nhập")
    @Min(value = 1,message = "Giá phải lớn hơn hoặc bằng một")
    private int childrenPrice;
    @NotBlank(message = "Trường bắt buộc phải nhập")
    private String tourGuide;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(int adultPrice) {
        this.adultPrice = adultPrice;
    }

    public int getChildrenPrice() {
        return childrenPrice;
    }

    public void setChildrenPrice(int childrenPrice) {
        this.childrenPrice = childrenPrice;
    }

    public String getTourGuide() {
        return tourGuide;
    }

    public void setTourGuide(String tourGuide) {
        this.tourGuide = tourGuide;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public TourDTO(int id, String name, boolean isDelete, int quantity, String image, MultipartFile file, String description, int adultPrice, int childrenPrice, String tourGuide, LocalDate departureDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
        this.quantity = quantity;
        this.image = image;
        this.file = file;
        this.description = description;
        this.adultPrice = adultPrice;
        this.childrenPrice = childrenPrice;
        this.tourGuide = tourGuide;
        this.departureDate = departureDate;
        this.endDate = endDate;
    }

    public TourDTO() {
    }

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
    }
}
