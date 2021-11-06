package com.yakut.springbootweather.repository;

import com.yakut.springbootweather.models.City;
import com.yakut.springbootweather.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    
    Optional<Weather> findByCity(String city);

    Optional<Weather> findFirstByCityOrderBySaveDateDesc(String city);
}
