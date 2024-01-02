package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "img")
public class Img {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "LONGTEXT")
    private String img;
    private int typeImg;
    private String name;

    @ManyToOne
    @JoinColumn(name = "tour_id",referencedColumnName = "id")
    private Tour tour;

    public Img() {
    }

    public Img(String name, int id, String img, int typeImg, Tour tour) {
        this.name = name;
        this.id = id;
        this.img = img;
        this.typeImg = typeImg;
        this.tour = tour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getTypeImg() {
        return typeImg;
    }

    public void setTypeImg(int typeImg) {
        this.typeImg = typeImg;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
