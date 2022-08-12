package com.innowise.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.innowise.demo.owm")
@EnableJpaRepositories("com.innowise.demo.dao")
public class ActivityWorker {
    public static void main(String[] args) {
        SpringApplication.run(ActivityWorker.class, args);
    }


}
