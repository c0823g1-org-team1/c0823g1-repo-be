package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "location_tour")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationTour {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String location;
    private Date date;
    private int typeTour;
    private boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "tour_id",referencedColumnName = "id")
    private Tour tour;

    @OneToOne(mappedBy = "locationTour")
    private DetailLocation detailLocation;

}
