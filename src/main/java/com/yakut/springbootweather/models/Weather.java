package com.yakut.springbootweather.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private LocalDateTime dateTime;
    @Column(name = "city")
    private String city;
    @Column(name = "temperature")
    @JsonProperty("t")
    private double temperature;
    @Column(name = "relative_humidity")
    @JsonProperty("r")
    private double relativeHumidity;
    @Column(name = "surface_pressure")
    @JsonProperty("sp")
    private double surfacePressure;
    @Column(name = "rainfall")
    @JsonProperty("tp")
    private double rainfall;
}
