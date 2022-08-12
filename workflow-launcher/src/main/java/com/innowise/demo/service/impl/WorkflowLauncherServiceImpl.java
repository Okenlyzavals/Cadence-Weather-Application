package com.innowise.demo.service.impl;

import com.innowise.demo.ClientFactory;
import com.innowise.demo.dto.WeatherReportDto;
import com.innowise.demo.service.WorkflowLauncherService;
import com.innowise.demo.workflow.WeatherReportWorkflow;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class WorkflowLauncherServiceImpl implements WorkflowLauncherService {

    private final ClientFactory clientFactory;

    @Override
    public WeatherReportDto processWorkflow(String city) {
        WorkflowClient client = clientFactory.buildClient();
        WeatherReportWorkflow workflow = client.newWorkflowStub(
                WeatherReportWorkflow.class, new WorkflowOptions.Builder()
                        .setExecutionStartToCloseTimeout(Duration.ofMinutes(600))
                        .setTaskList(ClientFactory.TASK_LIST)
                        .build());

        return workflow.fetchAndStoreWeatherReport(city);
    }

}
