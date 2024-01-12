package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface RankDTO {
    String getNameClient();
    int getAdultNumber();
    int getChildrenNumber();
    boolean getStatus();
    int getAdultPrice();
    int getChildrenPrice();
    String getNameTour();
    String getnameTourGuild();
    LocalDateTime getDate();
    LocalDate getDepartureDate();
    LocalDate getEndDate();


}
