package com.innowise.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="weather_reports")
public class WeatherReport{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id")
    private Long id;

    @Column(name = "measure_date", nullable = false)
    private LocalDateTime measureDate;

    @Column(name = "temperature", nullable = false)
    private Double tempCelsius;

    @JsonProperty("name")
    @Column(name = "city", nullable = false, length = 128)
    private String city;

    @JsonProperty("main")
    private void unpackTemperature(Map<String, Object> main){
        this.tempCelsius = (Double) main.get("temp");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherReport report = (WeatherReport) o;
        return Objects.equals(id, report.id)
                && Objects.equals(measureDate, report.measureDate)
                && Objects.equals(tempCelsius, report.tempCelsius)
                && Objects.equals(city, report.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, measureDate, tempCelsius, city);
    }
}