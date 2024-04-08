package com.codecool.solarwatch.service;

import com.codecool.solarwatch.errorhandling.InvalidDateException;
import com.codecool.solarwatch.model.city.City;
import com.codecool.solarwatch.model.solar.SunriseSunsetInfo;
import com.codecool.solarwatch.service.fetcher.SolarFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class SolarService {
    private final SolarFetcher solarFetcher;
    private final CityService cityService;

    @Autowired
    public SolarService(SolarFetcher solarFetcher, CityService cityService) {
        this.solarFetcher = solarFetcher;
        this.cityService = cityService;
    }

    public SunriseSunsetInfo getSolarInfo(String cityName, String dateStr) {
        LocalDate date = validateDateFormat(dateStr);

        City city = cityService.getCity(cityName);

        SunriseSunsetInfo solarInfo = solarFetcher.fetchSolarInfo(city, date);

        return solarInfo;
    }


    private LocalDate validateDateFormat(String dateStr) {
        if (dateStr != null && !dateStr.isEmpty()) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                return LocalDate.parse(dateStr, formatter);
            } catch (DateTimeParseException e) {
                throw new InvalidDateException();
            }
        } else {
            return LocalDate.now();
        }
    }
}
