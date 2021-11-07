package com.yakut.springbootweather.service;

import com.yakut.springbootweather.exception.NoCityBDException;
import com.yakut.springbootweather.models.Weather;
import com.yakut.springbootweather.repository.WeatherRepository;
import com.yakut.springbootweather.models.Cities;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class WeatherServiceImpl implements WeatherService {

    @Value("${url}")
    private String URL;
    @Value("${dateTimeAndToken}")
    private String dateTimeAndToken;
    private final WeatherRepository repository;
    private final RestTemplate restTemplate;

    @Override
    public Weather findOutWeatherInCityAndSaveInDatabase(Cities city) {
        Weather body = restTemplate.exchange(URL + city.getCity() + dateTimeAndToken,
                        HttpMethod.GET,null, Weather.class).getBody();
        body.setCity(city.name());
        body.setDateTime(LocalDateTime.now());
        repository.save(body);
        return body;
    }

    @Override
    @Transactional(readOnly = true)
    public Weather showTheWeatherOfOneCity(Cities city, LocalDateTime saveDateTime) throws NoCityBDException {
        if (saveDateTime != null) {
            return repository.findFirstByCityAndDateTimeLessThanEqualOrderByDateTimeDesc(city.name(), saveDateTime)
                    .orElseThrow(NoCityBDException::new);
        }
        return repository.findFirstByCityOrderByDateTimeDesc(city.name())
                .orElseGet(() -> findOutWeatherInCityAndSaveInDatabase(city));
    }

}
