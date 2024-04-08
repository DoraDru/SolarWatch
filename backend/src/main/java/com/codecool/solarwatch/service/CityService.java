package com.codecool.solarwatch.service;

import com.codecool.solarwatch.model.city.City;
import com.codecool.solarwatch.service.fetcher.CityFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private final CityFetcher cityFetcher;

    @Autowired
    public CityService(CityFetcher cityDetailsFetcher) {
        this.cityFetcher = cityDetailsFetcher;
    }

    public City getCity(String cityName){
        String formattedCityName = formatCityName(cityName);
        City city = cityFetcher.getGeoCodingCoordinates(formattedCityName);
        return city;
    }



    protected String formatCityName(String cityName) {
        if (cityName != null && !cityName.isEmpty()) {
            String[] words = cityName.split("[._*%-]");

            StringBuilder stringBuilder = new StringBuilder();
            for (String word : words) {
                stringBuilder.append(Character.toUpperCase(word.charAt(0)));
                stringBuilder.append(word.substring(1).toLowerCase());
                stringBuilder.append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            return stringBuilder.toString();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
