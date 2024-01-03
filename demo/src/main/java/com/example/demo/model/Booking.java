package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "booking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private String inforClient;
    private int adultNumber;
    private int childrenNumber;
    private boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "price_id", referencedColumnName = "id")
    private Price price;

    @OneToMany(mappedBy = "booking")
    private Set<DetailPersonTour> detailPersonTours;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @OneToMany(mappedBy = "booking")
    private Set<Payment> payments;

    @ManyToOne
    @JoinColumn(name = "tour_id",referencedColumnName = "id")
    private Tour tour;



}
