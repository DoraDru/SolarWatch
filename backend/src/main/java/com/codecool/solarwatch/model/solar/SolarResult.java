package com.codecool.solarwatch.model.solar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SolarResult(@JsonProperty("results") SolarResultDetails results) {
}
