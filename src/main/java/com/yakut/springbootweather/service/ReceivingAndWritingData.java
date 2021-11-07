package com.yakut.springbootweather.service;

import com.yakut.springbootweather.models.Cities;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReceivingAndWritingData {

    private final WeatherService weatherService;

    @Scheduled(fixedRate = 300000)
    public void ReceivingAndRecordingWeather() {
        weatherService.findOutWeatherInCityAndSaveInDatabase(Cities.MOSCOW);
        weatherService.findOutWeatherInCityAndSaveInDatabase(Cities.MINSK);
        weatherService.findOutWeatherInCityAndSaveInDatabase(Cities.ST_PETERSBURG);
        weatherService.findOutWeatherInCityAndSaveInDatabase(Cities.YEKATERINBURG);
        weatherService.findOutWeatherInCityAndSaveInDatabase(Cities.KHARKOV);
    }
}
