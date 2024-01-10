package com.example.demo.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "tour_guild")
public class TourGuild {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date date;
    private String phoneGuild;
    private String emailGuild;
    private boolean isDelete;

    @OneToMany(mappedBy = "tourGuild")
    private Set<Tour> tour;

    public TourGuild() {
    }

    public TourGuild(int id, String name, Date date, String phoneGuild, String emailGuild, boolean isDelete, Set<Tour> tour) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.phoneGuild = phoneGuild;
        this.emailGuild = emailGuild;
        this.isDelete = isDelete;
        this.tour = tour;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhoneGuild() {
        return phoneGuild;
    }

    public void setPhoneGuild(String phoneGuild) {
        this.phoneGuild = phoneGuild;
    }

    public String getEmailGuild() {
        return emailGuild;
    }

    public void setEmailGuild(String emailGuild) {
        this.emailGuild = emailGuild;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Set<Tour> getTour() {
        return tour;
    }

    public void setTour(Set<Tour> tour) {
        this.tour = tour;
    }
}
