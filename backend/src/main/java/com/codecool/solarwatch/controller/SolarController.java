package com.codecool.solarwatch.controller;

import com.codecool.solarwatch.errorhandling.InvalidDateException;
import com.codecool.solarwatch.model.solar.SunriseSunsetInfo;
import com.codecool.solarwatch.service.SolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/api")
public class SolarController {
    private final SolarService solarService;

    @Autowired
    public SolarController(SolarService solarService) {
        this.solarService = solarService;
    }

    @GetMapping("/solarwatch")
    public SunriseSunsetInfo getSunriseSunsetInfo(@RequestParam String city, @RequestParam(required = false) String date) {
        return solarService.getSolarInfo(city, validateDateFormat(date));
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
