package dev.patika.weatherapi.controller;

import dev.patika.weatherapi.model.WeatherForecast;
import dev.patika.weatherapi.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/{city}")
    public WeatherForecast getWeatherForecast(@PathVariable String city) {
        return weatherService.getWeatherForecast(city);
    }
}
