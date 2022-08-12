package com.innowise.demo.activity.impl;

import com.innowise.demo.activity.StoreWeatherActivity;
import com.innowise.demo.entity.WeatherReport;
import com.innowise.demo.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreWeatherActivityImpl implements StoreWeatherActivity {

    private final WeatherService service;

    @Override
    public WeatherReport storeWeatherReport(WeatherReport report) {
        return service.saveReport(report);
    }
}
