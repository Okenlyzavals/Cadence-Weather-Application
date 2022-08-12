package com.innowise.demo;

import com.uber.cadence.client.WorkflowClient;

public interface ClientFactory {

    String TASK_LIST = "task-list";
    WorkflowClient buildClient();
}
