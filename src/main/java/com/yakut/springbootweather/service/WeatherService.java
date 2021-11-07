package com.yakut.springbootweather.service;

import com.yakut.springbootweather.exception.NoCityBDException;
import com.yakut.springbootweather.models.Weather;
import com.yakut.springbootweather.models.Cities;
import java.time.LocalDateTime;

public interface WeatherService {

    Weather showTheWeatherOfOneCity(Cities city, LocalDateTime saveDateTime) throws NoCityBDException;

    Weather findOutWeatherInCityAndSaveInDatabase(Cities city);
}
