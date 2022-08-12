package com.innowise.demo.dto;

import com.innowise.demo.entity.WeatherReport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class WeatherReportDto {
    private String city;
    private LocalDateTime measureTimestamp;
    private Double temperature;

    public static WeatherReportDto of(WeatherReport report){
        return new WeatherReportDto(
                report.getCity(),
                report.getMeasureDate(),
                report.getTempCelsius());
    }
}
