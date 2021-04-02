package com.exam.project.models;

import javax.persistence.*;

@Entity
@Table(name = "dunLaoghaire_park")
public class DunLaoghairePark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    private String openingHours;
    private String directions;
    private String facilities;
    private String bus;
    @Column(name = "car", columnDefinition = "LONGTEXT")
    private String car;
    private String dart;

    public DunLaoghairePark() {

    }

    public DunLaoghairePark(Long id, String name, String description, String openingHours, String directions, String facilities, String bus, String car, String dart) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.openingHours = openingHours;
        this.directions = directions;
        this.facilities = facilities;
        this.bus = bus;
        this.car = car;
        this.dart = dart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getDart() {
        return dart;
    }

    public void setDart(String dart) {
        this.dart = dart;
    }
}
