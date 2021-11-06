package com.yakut.springbootweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringBootWeatherApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWeatherApplication.class, args);
    }
}
