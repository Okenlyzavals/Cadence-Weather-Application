package com.innowise.demo.activity;

import com.innowise.demo.entity.WeatherReport;
import com.uber.cadence.activity.ActivityMethod;

import static com.innowise.demo.ClientFactory.TASK_LIST;
public interface StoreWeatherActivity {
    @ActivityMethod(scheduleToCloseTimeoutSeconds = 30,
            scheduleToStartTimeoutSeconds = 30, taskList = TASK_LIST)
    WeatherReport storeWeatherReport(WeatherReport report);
}
