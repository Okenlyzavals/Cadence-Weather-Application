package com.innowise.demo.service;

import com.innowise.demo.entity.WeatherReport;

import java.util.Optional;

public interface WeatherService {
    Optional<WeatherReport> fetchForCity(String city);
    WeatherReport saveReport(WeatherReport report);
}
