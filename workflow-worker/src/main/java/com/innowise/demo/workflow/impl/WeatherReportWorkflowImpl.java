package com.innowise.demo.workflow.impl;

import com.innowise.demo.activity.RetrieveWeatherActivity;
import com.innowise.demo.activity.StoreWeatherActivity;
import com.innowise.demo.dto.WeatherReportDto;
import com.innowise.demo.entity.WeatherReport;
import com.innowise.demo.exception.NotFoundException;
import com.innowise.demo.workflow.WeatherReportWorkflow;
import com.uber.cadence.workflow.Workflow;

import java.util.Optional;

public class WeatherReportWorkflowImpl implements WeatherReportWorkflow {

    private final RetrieveWeatherActivity retrieveWeatherActivity;
    private final StoreWeatherActivity storeWeatherActivity;

    public WeatherReportWorkflowImpl(){
        this.retrieveWeatherActivity = Workflow.newActivityStub(RetrieveWeatherActivity.class);
        this.storeWeatherActivity = Workflow.newActivityStub(StoreWeatherActivity.class);
    }

    @Override
    public WeatherReportDto fetchAndStoreWeatherReport(String city) {
        Optional<WeatherReport> reportOptional = retrieveWeatherActivity.fetchWeatherReport(city);

        WeatherReport report = storeWeatherActivity.storeWeatherReport(
                reportOptional.orElseThrow(NotFoundException::new));

        return WeatherReportDto.of(report);
    }
}
