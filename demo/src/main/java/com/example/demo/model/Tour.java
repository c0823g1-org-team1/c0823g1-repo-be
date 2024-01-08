package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "tour")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private boolean isDelete;
    private int quantity;
    @Column(columnDefinition = "LONGTEXT")
    private String image;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    private int adultPrice;
    private int childrenPrice;
    private LocalDate departureDate;
    private LocalDate endDate;
    private int view;
    private int careAbout;

    @OneToMany(mappedBy = "tour")
    private Set<Booking> booking;


    @OneToMany(mappedBy = "tour")
    private Set<LocationTour> locationTours;

    @ManyToOne
    @JoinColumn(name = "tourGuild_id",referencedColumnName = "id")
    private TourGuild tourGuild;

    public int numberView(int count) {
        int number = 0;
        if (count > 300) {
            number = 10;
        } else if (count > 200) {
            number = 9;
        } else if (count > 150) {
            number = 8;
        } else if (count > 100) {
            number = 7;
        } else {
            number = 6;
        }
        return number;
    }


}
