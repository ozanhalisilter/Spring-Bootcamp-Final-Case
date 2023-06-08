package dev.patika.weatherapi.repository;

import dev.patika.weatherapi.model.WeatherForecast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<WeatherForecast, Long> {
    WeatherForecast findByCity(String city);
}

