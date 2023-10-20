package com.plannerapp.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity{
    @Column(nullable = false)
    @Length(min = 2,max = 50)
    private String description;
    @Column(nullable = false)
    @Future
    private LocalDate dueDate;
    @NotNull
    @ManyToOne
    private Priority priority;

    @ManyToOne
    private User assignee;

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Task setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Priority getPriority() {
        return priority;
    }

    public Task setPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public User getAssignee() {
        return assignee;
    }

    public Task setAssignee(User assignee) {
        this.assignee = assignee;
        return this;
    }
}
