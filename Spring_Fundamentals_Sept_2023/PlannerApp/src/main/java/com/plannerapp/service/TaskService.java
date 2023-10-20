package com.plannerapp.service;

import com.plannerapp.model.dto.task.TaskHomeViewModel;
import com.plannerapp.model.dto.task.TasksAddBidingModel;

public interface TaskService {
    void add(TasksAddBidingModel tasksAddBindingModel);

    void remove(Long id);

    void assign(Long id, String username);

    TaskHomeViewModel getHomeViewData(String username);
}
