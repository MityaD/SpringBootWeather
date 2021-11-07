package com.yakut.springbootweather.restController;

import com.yakut.springbootweather.exception.NoCityBDException;
import com.yakut.springbootweather.models.Cities;
import com.yakut.springbootweather.models.Weather;
import com.yakut.springbootweather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/weather")
public class AllRestController {

    private final WeatherService weatherService;

    @GetMapping("/{city}")// todo метод гет поразумевает что т=ты не будешь менять данные
    public Weather getWeatherCityForDate(@PathVariable Cities city,
                                         @RequestParam(value = "localDateTime", required = false)//todo зачем явно давать название параметра если переменная называется также?
                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                         LocalDateTime localDateTime) throws NoCityBDException {
        return weatherService.showTheWeatherOfOneCity(city, localDateTime);
    }
}
