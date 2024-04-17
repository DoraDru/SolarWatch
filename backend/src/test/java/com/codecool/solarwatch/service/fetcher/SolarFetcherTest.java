package com.codecool.solarwatch.service.fetcher;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class SolarFetcherTest {

    @Mock
    private WebClient webClient;
    @InjectMocks
    private SolarFetcher solarFetcher;


    @Test
    void testConvertToLocalTime_ShortTime() {
        String time = "7:27:02 AM";

        LocalTime expected = LocalTime.parse("07:27:02");
        LocalTime result = solarFetcher.convertToLocalTime(time);

        assertEquals(expected,result);
    }

    @Test
    void testConvertToLocalTime_LongTime() {
        String time = "11:27:02 PM";

        LocalTime expected = LocalTime.parse("23:27:02");
        LocalTime result = solarFetcher.convertToLocalTime(time);

        assertEquals(expected,result);
    }
}