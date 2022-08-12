package com.innowise.demo.impl;

import com.innowise.demo.ClientFactory;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import org.springframework.stereotype.Component;

@Component
public class ClientFactoryImpl implements ClientFactory {

    private static final String DOMAIN = "weather-domain";
    private static final String HOST = "cadence";
    private static final int CADENCE_PORT = 7933;

    @Override
    public WorkflowClient buildClient() {
        return WorkflowClient.newInstance(
                new WorkflowServiceTChannel(
                        ClientOptions.newBuilder().setHost(HOST).setPort(CADENCE_PORT).build()),
                WorkflowClientOptions.newBuilder().setDomain(DOMAIN).build());
    }
}
