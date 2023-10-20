package com.plannerapp.model.dto.task;

import com.plannerapp.model.entity.Task;
import com.plannerapp.model.enums.PriorityName;

public class TaskDTO {
    private Long id;
    private String description;
    private String dueDate;
    private PriorityName priority;

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public TaskDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public TaskDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public TaskDTO setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public PriorityName getPriority() {
        return priority;
    }

    public TaskDTO setPriority(PriorityName priority) {
        this.priority = priority;
        return this;
    }

    public static TaskDTO createFromTask(Task task){
        return new TaskDTO()
                .setId(task.getId())
                .setDescription(task.getDescription())
                .setPriority(task.getPriority().getName())
                .setDueDate(task.getDueDate().toString());
    }
}
