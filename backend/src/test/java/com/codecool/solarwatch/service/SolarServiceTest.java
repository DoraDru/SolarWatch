package com.codecool.solarwatch.service;

import com.codecool.solarwatch.model.city.City;
import com.codecool.solarwatch.model.solar.SunriseSunsetInfo;
import com.codecool.solarwatch.repository.SolarRepository;
import com.codecool.solarwatch.service.fetcher.SolarFetcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SolarServiceTest {

    @Mock
    private SolarFetcher solarFetcher;
    @Mock
    private SolarRepository solarRepository;
    @Mock
    private CityService cityService;
    @InjectMocks
    private SolarService solarService;

    @Test
    void testGetSolarInfo_WhenItIsInRepository() {
        LocalDate date = LocalDate.of(2024, 4, 17);
        String cityName = "Budapest";
        City city = new City(cityName, 40.7128, -74.0060, "HU", null);
        SunriseSunsetInfo solarInfo = new SunriseSunsetInfo(date, LocalTime.parse("06:43:12"), LocalTime.parse("18:43:12"), city);

        Mockito.when(cityService.getCity(cityName)).thenReturn(city);
        Mockito.when(solarRepository.getByCityAndDate(city, date)).thenReturn(Optional.of(solarInfo));

        SunriseSunsetInfo result = solarService.getSolarInfo(cityName, date);

        assertEquals(solarInfo, result);
        Mockito.verify(solarFetcher, Mockito.never()).fetchSolarInfo(Mockito.any(City.class), Mockito.any(LocalDate.class));
    }

    @Test
    void testGetSolarInfo_WhenItIsNotInRepository() {
        LocalDate date = LocalDate.of(2024, 4, 17);
        String cityName = "Budapest";
        City city = new City(cityName, 40.7128, -74.0060, "HU", null);
        SunriseSunsetInfo solarInfo = new SunriseSunsetInfo(date, LocalTime.parse("06:43:12"), LocalTime.parse("18:43:12"), city);

        Mockito.when(cityService.getCity(cityName)).thenReturn(city);
        Mockito.when(solarRepository.getByCityAndDate(city, date)).thenReturn(Optional.empty());
        Mockito.when(solarFetcher.fetchSolarInfo(city, date)).thenReturn(solarInfo);

        SunriseSunsetInfo result = solarService.getSolarInfo(cityName, date);

        assertEquals(solarInfo, result);
        Mockito.verify(solarFetcher, Mockito.times(1)).fetchSolarInfo(Mockito.any(City.class), Mockito.any(LocalDate.class));
    }
}