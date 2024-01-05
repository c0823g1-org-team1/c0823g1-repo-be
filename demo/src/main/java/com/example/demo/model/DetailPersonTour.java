package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detail_persont_tour")
public class DetailPersonTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tourGuide;
    private boolean isDelete;
    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;


    public DetailPersonTour() {
    }

    public DetailPersonTour(int id, String tourGuide, boolean isDelete, Booking booking) {
        this.id = id;
        this.tourGuide = tourGuide;
        this.isDelete = isDelete;
        this.booking = booking;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTourGuide() {
        return tourGuide;
    }

    public void setTourGuide(String tourGuide) {
        this.tourGuide = tourGuide;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
