package com.codecool.solarwatch.controller;

import com.codecool.solarwatch.errorhandling.InvalidDateException;
import com.codecool.solarwatch.service.SolarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SolarControllerTest {

    @Mock
    private SolarService solarService;
    @InjectMocks
    private SolarController solarController;

    @Test
    void testValidateDateFormat_CorrectDateAndFormat() {
        String date = "2024-04-22";

        LocalDate expected = LocalDate.parse("2024-04-22");
        LocalDate result = solarController.validateDateFormat(date);

        assertEquals(expected, result);
    }

    @Test
    void testValidateDateFormat_InvalidDateAndCorrectFormat() {
        String date = "2024-22-22";

        assertThrows(InvalidDateException.class, () -> solarController.validateDateFormat(date));
    }

    @Test
    void testValidateDateFormat_CorrectDateAndInvalidFormat() {
        String date = "2024-4-22";

        assertThrows(InvalidDateException.class, () -> solarController.validateDateFormat(date));
    }

    @Test
    void testValidateDateFormat_InvalidDateAndInvalidFormat() {
        String date = "2024-4-44";

        assertThrows(InvalidDateException.class, () -> solarController.validateDateFormat(date));
    }

    @Test
    void testValidateDateFormat_NotADate() {
        String date = "cicamano";

        assertThrows(InvalidDateException.class, () -> solarController.validateDateFormat(date));
    }

    @Test
    void testValidateDateFormat_DateIsNull() {
        LocalDate expected = LocalDate.now();
        LocalDate result = solarController.validateDateFormat(null);

        assertEquals(expected, result);
    }

    @Test
    void testValidateDateFormat_DateIsEmptyString() {
        String date = "";

        LocalDate expected = LocalDate.now();
        LocalDate result = solarController.validateDateFormat(date);

        assertEquals(expected, result);
    }
}