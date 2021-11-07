package com.yakut.springbootweather.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "weathers")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "save_date")
    private LocalDateTime saveDate; //todo навзвание гавно
    @Column(name = "city")
    private String city;
    @Column(name = "temperature")
    private double t;//todo давай переменные нормально назовешь, а то не понятно что это по одной букве
    @Column(name = "relative_humidity")
    private double r;
    @Column(name = "surface_pressure")
    private double sp;
    @Column(name = "rainfall")
    private double tp;
}
