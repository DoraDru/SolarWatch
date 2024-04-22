package com.codecool.solarwatch.service;

import com.codecool.solarwatch.errorhandling.InvalidCityException;
import com.codecool.solarwatch.model.city.City;
import com.codecool.solarwatch.repository.CityRepository;
import com.codecool.solarwatch.service.fetcher.CityFetcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CityServiceTest {

    @Mock
    private CityFetcher cityFetcher;
    @Mock
    private CityRepository cityRepository;
    @InjectMocks
    private CityService cityService;

    @Test
    void testGetCity_WhenCityIsInRepository() {
        String cityName = "Budapest";
        City city = new City(cityName, 40.7128, -74.0060, "HU", null);

        Mockito.when(cityRepository.getCityByName(cityName)).thenReturn(Optional.of(city));

        City result = cityService.getCity(cityName);

        assertEquals(city, result);
    }

    @Test
    void testGetCity_WhenCityIsNotInRepository() {
        String cityName = "Budapest";
        City city = new City(cityName, 40.7128, -74.0060, "HU", null);

        Mockito.when(cityRepository.getCityByName(cityName)).thenReturn(Optional.empty());
        Mockito.when(cityFetcher.getGeoCodingCoordinates(cityName)).thenReturn(city);

        City result = cityService.getCity(cityName);

        assertEquals(city, result);
    }

    @Test
    void testGetCity_InvalidCityName(){
        String cityName = "fsregfsdr";

        Mockito.when(cityFetcher.getGeoCodingCoordinates(cityName)).thenThrow(new InvalidCityException(cityName));

        assertThrows(InvalidCityException.class, () -> cityService.getCity(cityName));
    }

    @Test
    void testFormatCityName_MultipleWords() {
        String cityName = "New York";

        String formattedCityName = cityService.formatCityName("New%York");

        assertEquals(cityName, formattedCityName);
    }

    @Test
    void testFormatCityName_AllLowerCase() {
        String cityName = "Budapest";

        String formattedCityName = cityService.formatCityName("budapest");

        assertEquals(cityName, formattedCityName);
    }

    @Test
    void testFormatCityName_AllUpperCase() {
        String cityName = "Budapest";

        String formattedCityName = cityService.formatCityName("BUDAPEST");

        assertEquals(cityName, formattedCityName);
    }
}