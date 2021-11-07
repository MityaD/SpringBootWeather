package com.yakut.springbootweather.service;

import com.yakut.springbootweather.exception.NoCityBDException;
import com.yakut.springbootweather.models.Weather;
import com.yakut.springbootweather.models.City;
import java.time.LocalDateTime;

public interface WeatherService {

    Weather findWeatherByCityName(City city) throws NoCityBDException;

    Weather findOutWeatherInCityAndSaveInDatabase(City city);

    Weather findFirstByCityOrSaveDate(City city, LocalDateTime saveDateTime) throws NoCityBDException;
}
