package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "tour_guild")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}