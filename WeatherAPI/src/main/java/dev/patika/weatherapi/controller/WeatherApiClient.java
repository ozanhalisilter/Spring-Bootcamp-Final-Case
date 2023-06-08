package dev.patika.weatherapi.controller;

import dev.patika.weatherapi.model.WeatherForecast;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherApiClient {
    private final RestTemplate restTemplate;

    public WeatherApiClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public WeatherForecast getWeatherForecast(String city) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=494c6b1dac4121087ae8ef19d4fb9947";
        ResponseEntity<WeatherForecast> response = restTemplate.getForEntity(url, WeatherForecast.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to retrieve weather forecast");
        }
    }
}