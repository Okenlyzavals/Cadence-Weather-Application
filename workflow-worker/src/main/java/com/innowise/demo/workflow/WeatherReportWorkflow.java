package com.innowise.demo.workflow;

import com.innowise.demo.dto.WeatherReportDto;
import com.uber.cadence.workflow.WorkflowMethod;

public interface WeatherReportWorkflow {

    @WorkflowMethod
    WeatherReportDto fetchAndStoreWeatherReport(String city);
}
