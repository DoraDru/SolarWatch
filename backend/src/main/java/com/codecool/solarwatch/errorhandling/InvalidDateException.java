package com.codecool.solarwatch.errorhandling;

public class InvalidDateException extends RuntimeException{
    public InvalidDateException(String date) {
        super(String.format("Invalid date: %s \n" +
                "Date format must be YYYY-MM-DD", date));
    }
}
