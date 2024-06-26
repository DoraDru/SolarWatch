package com.codecool.solarwatch.model.city;

import com.codecool.solarwatch.model.solar.SunriseSunsetInfo;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private double latitude;
    private double longitude;
    private String country;
    private String state;
    @OneToMany(mappedBy = "city")
    private List<SunriseSunsetInfo> sunriseSunsetInfoList;

    public City(String name, double latitude, double longitude, String country, String state) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.state = state;
    }

    public City() {

    }


    public String getName() {
        return name;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }
}

