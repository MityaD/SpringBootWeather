package com.yakut.springbootweather.service;

import com.yakut.springbootweather.exception.NoCityBDException;
import com.yakut.springbootweather.models.Weather;
import com.yakut.springbootweather.repository.WeatherRepository;
import com.yakut.springbootweather.models.Cities;
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
    public Weather findOutWeatherInCityAndSaveInDatabase(Cities city) {
        Weather body = restTemplate.exchange("https://gridforecast.com/api/v1/forecast/" +
                        city.getCity() + "/202111071200?api_token=gPNf9QeGSArkACoK",
                HttpMethod.GET, null, Weather.class)
                .getBody();
        body.setCity(city.name());
        body.setSaveDate(LocalDateTime.now());
        repository.save(body);
        return body;
    }

    @Override
    public Weather showTheWeatherOfOneCity(Cities city, LocalDateTime saveDateTime) throws NoCityBDException{
        if (saveDateTime != null) {
            return repository.findFirstByCityAndSaveDateLessThanEqualOrderBySaveDateDesc(city.name(), saveDateTime)
                    .orElseThrow(NoCityBDException::new);
        }
        return repository.findFirstByCityOrderBySaveDateDesc(city.name())
                .orElseGet(() -> findOutWeatherInCityAndSaveInDatabase(city));
    }

}