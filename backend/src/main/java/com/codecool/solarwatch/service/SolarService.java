package com.codecool.solarwatch.service;

import com.codecool.solarwatch.model.city.City;
import com.codecool.solarwatch.model.solar.SunriseSunsetInfo;
import com.codecool.solarwatch.repository.SolarRepository;
import com.codecool.solarwatch.service.fetcher.SolarFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SolarService {
    private final SolarFetcher solarFetcher;
    private final CityService cityService;
    private final SolarRepository solarRepository;

    @Autowired
    public SolarService(SolarFetcher solarFetcher, CityService cityService, SolarRepository solarRepository) {
        this.solarFetcher = solarFetcher;
        this.cityService = cityService;
        this.solarRepository = solarRepository;
    }

    public SunriseSunsetInfo getSolarInfo(String cityName, LocalDate date) {
        City city = cityService.getCity(cityName);

        Optional<SunriseSunsetInfo> optionalSunriseSunset = solarRepository.getByCityAndDate(city, date);

        if (optionalSunriseSunset.isPresent()) {
            return optionalSunriseSunset.get();
        } else {
            SunriseSunsetInfo sunriseSunsetInfo = solarFetcher.fetchSolarInfo(city, date);
            solarRepository.save(sunriseSunsetInfo);
            return sunriseSunsetInfo;
        }
    }
}
