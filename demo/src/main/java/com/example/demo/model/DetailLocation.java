package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detail_location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailLocation {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "LONGTEXT")
    private String descriptionLocation;

    @OneToOne
    private LocationTour locationTour;
}
