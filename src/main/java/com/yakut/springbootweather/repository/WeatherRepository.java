package com.yakut.springbootweather.repository;

import com.yakut.springbootweather.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    Optional<Weather> findFirstByCityOrderBySaveDateDesc(String city);

    Optional<Weather> findFirstByCityAndSaveDateLessThanEqualOrderBySaveDateDesc(String city, LocalDateTime saveDateTime);
}
