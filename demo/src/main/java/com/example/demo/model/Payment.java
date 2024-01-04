package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean status;

//    @ManyToOne
//    @JoinColumn(name = "booking_id",referencedColumnName = "id")
//    private Booking booking;
    @OneToOne
    private Booking booking;

    public Payment() {
    }

    public Payment(int id, boolean status, Booking booking) {
        this.id = id;
        this.status = status;
        this.booking = booking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
