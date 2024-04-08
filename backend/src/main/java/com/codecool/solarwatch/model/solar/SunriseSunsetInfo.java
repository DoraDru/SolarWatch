package com.codecool.solarwatch.model.solar;

import java.time.LocalDate;
import java.time.LocalTime;

public class SunriseSunsetInfo {
    private LocalDate date;
    private LocalTime sunrise;
    private LocalTime sunset;

    public SunriseSunsetInfo(LocalDate date, LocalTime sunrise, LocalTime sunset) {
        this.date = date;
        this.sunrise = sunrise;
        this.sunset = sunset;
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
