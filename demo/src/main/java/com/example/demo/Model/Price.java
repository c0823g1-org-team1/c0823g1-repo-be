package com.example.demo.Model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int adultPrice;
    private int childrenPrice;
    private int typeTour;

    @OneToMany(mappedBy = "price")
    private Set<Tour> tours;

    @OneToMany(mappedBy = "price")
    private Set<Booking> bookings;
    public Price() {
    }

    public Price(int id, int adultPrice, int childrenPrice, int typeTour, Set<Tour> tours, Set<Booking> bookings) {
        this.id = id;
        this.adultPrice = adultPrice;
        this.childrenPrice = childrenPrice;
        this.typeTour = typeTour;
        this.tours = tours;
        this.bookings = bookings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Tour> getTours() {
        return tours;
    }

    public void setTours(Set<Tour> tours) {
        this.tours = tours;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public int getTypeTour() {
        return typeTour;
    }

    public void setTypeTour(int typeTour) {
        this.typeTour = typeTour;
    }
}
