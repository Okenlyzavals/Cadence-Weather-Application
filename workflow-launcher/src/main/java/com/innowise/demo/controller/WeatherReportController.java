package com.innowise.demo.controller;

import com.innowise.demo.dto.WeatherReportDto;
import com.innowise.demo.service.WorkflowLauncherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class WeatherReportController {

    private final WorkflowLauncherService service;

    @GetMapping("/temp/{city}")
    public WeatherReportDto getTempForCity(@PathVariable String city){
        return service.processWorkflow(city);
    }

}
