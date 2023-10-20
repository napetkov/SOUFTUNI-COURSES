package com.plannerapp.model.dto.task;

import com.plannerapp.model.annotation.StringDateInFuture;
import com.plannerapp.model.enums.PriorityName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TasksAddBidingModel {
    @Size(min = 2,max = 50,message = "Description length must be between 2 and 50 characters!")
    private String description;
    @StringDateInFuture(message = "Due Date must be in the future!")
    private String dueDate;
    @NotNull(message = "You must select a priority!")
    private PriorityName priority;

    public String getDescription() {
        return description;
    }

    public TasksAddBidingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public TasksAddBidingModel setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public PriorityName getPriority() {
        return priority;
    }

    public TasksAddBidingModel setPriority(PriorityName priority) {
        this.priority = priority;
        return this;
    }
}
