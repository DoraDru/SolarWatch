package com.codecool.solarwatch.service.fetcher;

import com.codecool.solarwatch.errorhandling.InvalidCityException;
import com.codecool.solarwatch.model.city.GeoCoordinates;
import com.codecool.solarwatch.model.city.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CityFetcher {
    @Value("${api.key}")
    private String API_KEY;
    private final WebClient webClient;

    public CityFetcher(WebClient webClient) {
        this.webClient = webClient;
    }

    public City getGeoCodingCoordinates(String cityName) {

        String url = String.format("https://api.openweathermap.org/geo/1.0/direct?q=%s&appid=%s", cityName, API_KEY);

        GeoCoordinates[] response = webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(GeoCoordinates[].class)
                .block();

        if (response != null && response.length > 0) {
            GeoCoordinates geoCodingCoordinates = response[0];

            return new City(
                    geoCodingCoordinates.name(),
                    geoCodingCoordinates.lat(),
                    geoCodingCoordinates.lon(),
                    geoCodingCoordinates.country(),
                    geoCodingCoordinates.state());
        } else {
            throw new InvalidCityException();
        }
    }
}
