package org.softuni.pathfinder.models;

import jakarta.persistence.*;
import org.softuni.pathfinder.models.enums.CategoryNames;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryNames name;
    @Column(name = "description")
    private String description;

    public Category() {
    }

    public CategoryNames getName() {
        return name;
    }

    public void setName(CategoryNames name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
