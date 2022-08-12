package com.innowise.demo.activity.impl;

import com.innowise.demo.activity.RetrieveWeatherActivity;
import com.innowise.demo.entity.WeatherReport;
import com.innowise.demo.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RetrieveWeatherActivityImpl implements RetrieveWeatherActivity {

    private final WeatherService service;

    @Override
    public Optional<WeatherReport> fetchWeatherReport(String city) {
        return service.fetchForCity(city);
    }
}
