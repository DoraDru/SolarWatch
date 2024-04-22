package com.codecool.solarwatch.model.solar;

import com.codecool.solarwatch.model.city.City;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class SunriseSunsetInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private LocalDate date;
    private LocalTime sunrise;
    private LocalTime sunset;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public SunriseSunsetInfo(LocalDate date, LocalTime sunrise, LocalTime sunset, City city) {
        this.date = date;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.city = city;
    }

    public SunriseSunsetInfo() {

    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getSunrise() {
        return sunrise;
    }

    public LocalTime getSunset() {
        return sunset;
    }
}
