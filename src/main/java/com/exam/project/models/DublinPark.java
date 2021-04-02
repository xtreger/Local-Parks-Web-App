package com.exam.project.models;

import javax.persistence.*;

@Entity
@Table(name = "dublin_park")
public class DublinPark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    @Column(name = "opening_hours_week", columnDefinition = "LONGTEXT")
    private String openingHoursWeek;
    @Column(name = "opening_hours_month", columnDefinition = "LONGTEXT")
    private String openingHoursMonth;
    private String phone;
    private String email;
    @Column(name = "facilities", columnDefinition = "LONGTEXT")
    private String facilities;
    @Column(name = "accessibility", columnDefinition = "LONGTEXT")
    private String accessibility;
    @Column(name = "address", columnDefinition = "LONGTEXT")
    private String address;

    public DublinPark() {

    }

    public DublinPark(Long id, String name, String description, String openingHoursWeek, String openingHoursMonth, String phone, String email, String facilities, String accessibility, String address) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.openingHoursWeek = openingHoursWeek;
        this.openingHoursMonth = openingHoursMonth;
        this.phone = phone;
        this.email = email;
        this.facilities = facilities;
        this.accessibility = accessibility;
        this.address = address;
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

    public String getOpeningHoursWeek() {
        return openingHoursWeek;
    }

    public void setOpeningHoursWeek(String openingHoursWeek) {
        this.openingHoursWeek = openingHoursWeek;
    }

    public String getOpeningHoursMonth() {
        return openingHoursMonth;
    }

    public void setOpeningHoursMonth(String openingHoursMonth) {
        this.openingHoursMonth = openingHoursMonth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

