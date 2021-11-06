package com.yakut.springbootweather.service;

import com.yakut.springbootweather.exception.NoCityBDException;
import com.yakut.springbootweather.models.Weather;
import com.yakut.springbootweather.models.City;

public interface WeatherService {

    void save(Weather weather);

    Weather findWeatherByCityName(City city) throws NoCityBDException;

    Weather findOutWeatherInCityAndSaveInDatabase(City city);
}
