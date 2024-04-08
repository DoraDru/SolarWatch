package com.codecool.solarwatch.controller;

import com.codecool.solarwatch.model.solar.SunriseSunsetInfo;
import com.codecool.solarwatch.service.SolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return solarService.getSolarInfo(city, date);
    }
}
