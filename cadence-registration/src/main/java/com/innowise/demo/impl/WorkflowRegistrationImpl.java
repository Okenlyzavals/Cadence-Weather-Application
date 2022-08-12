package com.innowise.demo.impl;

import com.innowise.demo.ClientFactory;
import com.innowise.demo.WorkflowRegistration;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.worker.Worker;
import com.uber.cadence.worker.WorkerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkflowRegistrationImpl implements WorkflowRegistration {

    private final ClientFactory clientFactory;

    @Override
    public void register(Class<?> workflowClass) {
        WorkflowClient workflowClient = clientFactory.buildClient();
        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
        Worker worker = factory.newWorker(ClientFactory.TASK_LIST);
        worker.registerWorkflowImplementationTypes(workflowClass);
        factory.start();
    }
}
