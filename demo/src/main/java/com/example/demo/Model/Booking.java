package com.example.demo.Model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Time time;
    private String inforClient;
    private int adultNumber;
    private int childrenNumber;

    @ManyToOne
    @JoinColumn(name = "price_id",referencedColumnName = "id")
    private Price price;

    @OneToMany(mappedBy = "booking")
    private Set<DetailPersonTour> detailPersonTours;
    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;

    public Booking() {
    }

    public Booking(int id, Time time, String inforClient, int adultNumber, int childrenNumber, Price price, Set<DetailPersonTour> detailPersonTours, Account account) {
        this.id = id;
        this.time = time;
        this.inforClient = inforClient;
        this.adultNumber = adultNumber;
        this.childrenNumber = childrenNumber;
        this.price = price;
        this.detailPersonTours = detailPersonTours;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getInforClient() {
        return inforClient;
    }

    public void setInforClient(String inforClient) {
        this.inforClient = inforClient;
    }

    public int getAdultNumber() {
        return adultNumber;
    }

    public void setAdultNumber(int adultNumber) {
        this.adultNumber = adultNumber;
    }

    public int getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(int childrenNumber) {
        this.childrenNumber = childrenNumber;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Set<DetailPersonTour> getDetailPersonTours() {
        return detailPersonTours;
    }

    public void setDetailPersonTours(Set<DetailPersonTour> detailPersonTours) {
        this.detailPersonTours = detailPersonTours;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
