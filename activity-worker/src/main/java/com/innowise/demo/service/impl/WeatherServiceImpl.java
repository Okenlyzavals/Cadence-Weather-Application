package com.innowise.demo.service.impl;

import com.innowise.demo.dao.WeatherReportRepository;
import com.innowise.demo.entity.WeatherReport;
import com.innowise.demo.owm.OwmProxy;
import com.innowise.demo.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private static final String API_KEY = "79880505d4bc38fade2dcea69912f40c";

    private final OwmProxy proxy;
    private final WeatherReportRepository repository;

    @Override
    public Optional<WeatherReport> fetchForCity(String city) {
        Optional<WeatherReport> result;

        try{
            WeatherReport report = proxy.retrieveReport(city, API_KEY);
            report.setMeasureDate(LocalDateTime.now());
            result = Optional.of(report);
        } catch (Exception e){
            result = Optional.empty();
        }

        return result;
    }

    @Override
    public WeatherReport saveReport(WeatherReport report) {
        report.setId(null);
        return repository.save(report);
    }
}
