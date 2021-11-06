package com.yakut.springbootweather.service;

import com.yakut.springbootweather.models.Weather;
import com.yakut.springbootweather.repository.WeatherRepository;
import com.yakut.springbootweather.models.City;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository repository;
    private final RestTemplate restTemplate;

    @Override
    public void save(Weather weather) {
        repository.save(weather);
    }

    @Override
    public Weather findWeatherByCityName(City city){
        return repository.findByCity(city.name()).orElseGet(() -> findOutWeatherInCityAndSaveInDatabase(city));
    }

    @Override
    public Weather findOutWeatherInCityAndSaveInDatabase(City city) {
        Weather body = restTemplate.exchange("https://gridforecast.com/api/v1/forecast/" +
                        city.getCity() + "/202111051200?api_token=gPNf9QeGSArkACoK",
                HttpMethod.GET, null, Weather.class)
                .getBody();
        body.setCity(city.name());
        body.setSaveDate(LocalDateTime.now());
        repository.save(body);
        return body;
    }
}
