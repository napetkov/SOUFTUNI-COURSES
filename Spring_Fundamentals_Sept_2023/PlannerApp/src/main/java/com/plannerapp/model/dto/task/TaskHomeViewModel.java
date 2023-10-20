package com.plannerapp.model.dto.task;

import java.util.ArrayList;
import java.util.List;

public class TaskHomeViewModel {
    List<TaskDTO> assignedTasks;
    List<TaskDTO> availableTasks;

    public TaskHomeViewModel() {
        this(new ArrayList<>(),new ArrayList<>());
    }

    public TaskHomeViewModel(List<TaskDTO> assignedTasks, List<TaskDTO> availableTasks) {
        this.assignedTasks = assignedTasks;
        this.availableTasks = availableTasks;
    }

    public List<TaskDTO> getAssignedTasks() {
        return assignedTasks;
    }

    public TaskHomeViewModel setAssignedTasks(List<TaskDTO> assignedTasks) {
        this.assignedTasks = assignedTasks;
        return this;
    }

    public List<TaskDTO> getAvailableTasks() {
        return availableTasks;
    }

    public TaskHomeViewModel setAvailableTasks(List<TaskDTO> availableTasks) {
        this.availableTasks = availableTasks;
        return this;
    }
}
