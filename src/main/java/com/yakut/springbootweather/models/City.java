package com.yakut.springbootweather.models;

import lombok.Getter;

@Getter
public enum City {
    MOSCOW("55.7522;37.6155"),
    MINSK ("53.9000;27.5666"),
    ST_PETERSBURG ("59.9386;30.3141"),
    YEKATERINBURG ("56.8519;60.6122"),
    KHARKOV ("49.9957;36.2428");

    String city;

    City(String city) {
        this.city = city;
    }
}
