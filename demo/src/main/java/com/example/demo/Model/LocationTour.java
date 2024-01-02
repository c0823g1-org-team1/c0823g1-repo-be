package com.example.demo.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "location_tour")
public class LocationTour {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String location;
    private Date date;
    private int typeTour;

    @ManyToOne
    @JoinColumn(name = "tour_id",referencedColumnName = "id")
    private Tour tour;

    public LocationTour() {
    }

    public LocationTour(int id, String location, Date date, int typeTour, Tour tour) {
        this.id = id;
        this.location = location;
        this.date = date;
        this.typeTour = typeTour;
        this.tour = tour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTypeTour() {
        return typeTour;
    }

    public void setTypeTour(int typeTour) {
        this.typeTour = typeTour;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
