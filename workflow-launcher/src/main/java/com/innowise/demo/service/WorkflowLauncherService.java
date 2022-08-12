package com.innowise.demo.service;

import com.innowise.demo.dto.WeatherReportDto;

public interface WorkflowLauncherService {
    WeatherReportDto processWorkflow(String city);
}
