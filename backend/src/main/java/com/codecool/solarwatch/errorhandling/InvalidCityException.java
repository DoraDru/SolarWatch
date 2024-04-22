package com.codecool.solarwatch.errorhandling;

public class InvalidCityException extends RuntimeException {
    public InvalidCityException(String city) {
        super(String.format("Invalid city: %s", city));
    }
}
