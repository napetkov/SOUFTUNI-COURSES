package com.plannerapp.model.entity;

import com.plannerapp.model.enums.PriorityName;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "priorities")
public class Priority extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private PriorityName name;
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy = "priority")
    private Set<Task> tasks;

    private void setDescription(PriorityName name) {
        String description = "";

        switch (name) {
            case LOW -> description = "Should be fixed if time permits but can be postponed.";
            case URGENT -> description = "An urgent problem that blocks the system use until the issue is resolved.";
            case IMPORTANT ->
                    description = "A core functionality that your product is explicitly supposed to perform is compromised.";
        }
        this.description = description;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Priority setTasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    public PriorityName getName() {
        return name;
    }

    public Priority setName(PriorityName name) {
        this.name = name;
        setDescription(name);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Priority setDescription(String description) {
        this.description = description;
        return this;
    }
}
