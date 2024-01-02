package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "detail_persont_tour")
public class DetailPersonTour {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String tourGuide;
    private String client;

    @ManyToOne
    @JoinColumn(name = "booking_id",referencedColumnName = "id")
    private Booking booking;


    public DetailPersonTour() {
    }

    public DetailPersonTour(int id, String tourGuide, String client, Booking booking) {
        this.id = id;
        this.tourGuide = tourGuide;
        this.client = client;
        this.booking = booking;
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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
