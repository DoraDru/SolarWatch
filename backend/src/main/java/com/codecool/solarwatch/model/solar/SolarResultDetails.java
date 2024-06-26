package com.codecool.solarwatch.model.solar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SolarResultDetails(@JsonProperty("sunrise") String sunrise, @JsonProperty("sunset") String sunset) {
}
