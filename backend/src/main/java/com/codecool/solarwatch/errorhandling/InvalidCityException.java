package com.codecool.solarwatch.errorhandling;

public class InvalidCityException extends RuntimeException {
    public InvalidCityException() {
        super("Invalid city.");
    }
}
