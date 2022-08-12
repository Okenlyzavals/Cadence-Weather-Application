package com.innowise.demo.activity;

import com.innowise.demo.entity.WeatherReport;
import com.uber.cadence.activity.ActivityMethod;

import java.util.Optional;

import static com.innowise.demo.ClientFactory.TASK_LIST;
public interface RetrieveWeatherActivity {

    @ActivityMethod(scheduleToCloseTimeoutSeconds = 30,
            scheduleToStartTimeoutSeconds = 30, taskList = TASK_LIST)
    Optional<WeatherReport> fetchWeatherReport(String city);
}
