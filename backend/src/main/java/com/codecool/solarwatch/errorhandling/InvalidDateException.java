package com.codecool.solarwatch.errorhandling;

public class InvalidDateException extends RuntimeException{
    public InvalidDateException() {
        super("Invalid date.");
    }
}
