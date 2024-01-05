package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

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
    private String tourGuide;
    private Date departureDate;
    private Date endDate;

    @OneToMany(mappedBy = "tour")
    private Set<Booking> booking;


    @OneToMany(mappedBy = "tour")
    private Set<LocationTour> locationTours;


}
