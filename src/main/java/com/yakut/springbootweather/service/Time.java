package com.yakut.springbootweather.service;

import com.yakut.springbootweather.models.City;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@RequiredArgsConstructor
public class Time {

    private final WeatherService weatherService;

    @Scheduled(fixedRate = 300000)
    public void time() {
        weatherService.findOutWeatherInCityAndSaveInDatabase(City.MOSCOW);
        weatherService.findOutWeatherInCityAndSaveInDatabase(City.MINSK);
        weatherService.findOutWeatherInCityAndSaveInDatabase(City.ST_PETERSBURG);
        weatherService.findOutWeatherInCityAndSaveInDatabase(City.YEKATERINBURG);
        weatherService.findOutWeatherInCityAndSaveInDatabase(City.KHARKOV);
    }
}
