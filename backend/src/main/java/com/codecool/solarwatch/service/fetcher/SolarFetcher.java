package com.codecool.solarwatch.service.fetcher;

import com.codecool.solarwatch.model.city.City;
import com.codecool.solarwatch.model.solar.SolarResult;
import com.codecool.solarwatch.model.solar.SunriseSunsetInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class SolarFetcher {
    private final WebClient webClient;

    public SolarFetcher(WebClient webClient) {
        this.webClient = webClient;
    }

    public SunriseSunsetInfo fetchSolarInfo(City city, LocalDate date) {
        String url = getURL(date, city.getLatitude(), city.getLongitude());

        SolarResult response = webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(SolarResult.class)
                .block();

        if (response != null) {
            SunriseSunsetInfo sunriseSunsetInfo = new SunriseSunsetInfo(
                    date,
                    convertToLocalTime(response.results().sunrise()),
                    convertToLocalTime(response.results().sunset())
            );
            return sunriseSunsetInfo;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private String getURL(LocalDate date, double latitude, double longitude) {
        return String.format("https://api.sunrise-sunset.org/json?lat=%s&lng=%s&date=%s", latitude, longitude, date);
    }

    private LocalTime convertToLocalTime(String time) {
        int WRONG_TIME_FORMAT_LENGTH = 10;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        if (time.length() == WRONG_TIME_FORMAT_LENGTH) {
            String correctTimeFormat = "0" + time;
            return LocalTime.parse(correctTimeFormat, formatter);
        }
        return LocalTime.parse(time, formatter);
    }
}
