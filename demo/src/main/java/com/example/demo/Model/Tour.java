package com.example.demo.Model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "price_id", referencedColumnName = "id")
    private Price price;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;


    @OneToMany(mappedBy = "tour")
    private Set<LocationTour> locationTours;

    public Tour() {
    }


    public Tour(int id, String name, String description, Price price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Set<LocationTour> getLocationTours() {
        return locationTours;
    }

    public void setLocationTours(Set<LocationTour> locationTours) {
        this.locationTours = locationTours;
    }
}
