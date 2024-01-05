package com.example.demo.model;

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
    private boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "tour_id",referencedColumnName = "id")
    private Tour tour;

    public Img() {
    }

    public Img(int id, String img, int typeImg, String name, boolean isDelete, Tour tour) {
        this.id = id;
        this.img = img;
        this.typeImg = typeImg;
        this.name = name;
        this.isDelete = isDelete;
        this.tour = tour;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
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
