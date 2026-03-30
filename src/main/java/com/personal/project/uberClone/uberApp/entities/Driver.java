package com.personal.project.uberClone.uberApp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Entity
@Getter
@Setter
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double rating;

    private Boolean available;

//    4326 is basically for letting hibernate know its EARTH geometry(longitude and latitude)
    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point currentLocation;






}
