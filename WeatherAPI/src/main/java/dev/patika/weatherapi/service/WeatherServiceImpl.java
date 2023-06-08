package dev.patika.weatherapi.service;

import dev.patika.weatherapi.controller.WeatherApiClient;
import dev.patika.weatherapi.model.WeatherForecast;
import dev.patika.weatherapi.repository.WeatherRepository;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {
    private final WeatherApiClient weatherApiClient;
    private final WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherApiClient weatherApiClient, WeatherRepository weatherRepository) {
        this.weatherApiClient = weatherApiClient;
        this.weatherRepository = weatherRepository;
    }

    @Override
    public WeatherForecast getWeatherForecast(String city) {
        WeatherForecast forecast = weatherRepository.findByCity(city);

        if (forecast == null) {
            forecast = weatherApiClient.getWeatherForecast(city);

            weatherRepository.save(forecast);
        }

        return forecast;
    }
}