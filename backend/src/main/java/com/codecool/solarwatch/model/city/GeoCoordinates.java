package com.codecool.solarwatch.model.city;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GeoCoordinates( @JsonProperty("name") String name,
                              @JsonProperty("lat") double lat,
                              @JsonProperty("lon") double lon,
                              @JsonProperty("state") String state,
                              @JsonProperty("country") String country) {
}
