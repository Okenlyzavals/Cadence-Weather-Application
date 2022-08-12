package com.innowise.demo.owm;

import com.innowise.demo.entity.WeatherReport;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "owm-client", url = "https://api.openweathermap.org/")
public interface OwmProxy {

    @GetMapping(value = "data/2.5/weather?units=metric",
            produces = MediaType.APPLICATION_JSON_VALUE)
    WeatherReport retrieveReport(
            @RequestParam(value = "q") String city,
            @RequestParam(value = "appid") String apiKey);
}
