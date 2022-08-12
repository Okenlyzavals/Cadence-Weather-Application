package com.innowise.demo.impl;

import com.innowise.demo.ActivityRegistration;
import com.innowise.demo.ClientFactory;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.worker.Worker;
import com.uber.cadence.worker.WorkerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActivityRegistrationImpl implements ActivityRegistration {

    private final ClientFactory clientFactory;

    @Override
    public void register(Object... instances) {
        WorkflowClient workflowClient = clientFactory.buildClient();
        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
        Worker worker = factory.newWorker(ClientFactory.TASK_LIST);
        worker.registerActivitiesImplementations(instances);
        factory.start();
    }
}
