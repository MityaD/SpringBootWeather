package com.yakut.springbootweather.restController;

import com.yakut.springbootweather.exception.NoCityBDException;
import com.yakut.springbootweather.models.City;
import com.yakut.springbootweather.models.Weather;
import com.yakut.springbootweather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/weather")
public class AllRestController {

    private final RestTemplate restTemplate;
    private final WeatherService weatherService;

    @GetMapping("/{city}")
    public Weather getWeather(@PathVariable City city) throws NoCityBDException {
        return weatherService.findWeatherByCityName(city);
    }
}