package dev.patika.weatherapi.service;

import dev.patika.weatherapi.model.WeatherForecast;

public interface WeatherService {
    WeatherForecast getWeatherForecast(String city);
}
