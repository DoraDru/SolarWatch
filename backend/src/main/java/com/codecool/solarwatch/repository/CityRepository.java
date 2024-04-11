package com.codecool.solarwatch.repository;

import com.codecool.solarwatch.model.city.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> getCityByName(String name);
}
