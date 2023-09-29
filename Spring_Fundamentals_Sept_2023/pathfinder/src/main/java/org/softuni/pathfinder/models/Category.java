package org.softuni.pathfinder.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RouteCategories name;
    @Column(name = "description")
    private String description;

    public Category() {
    }

    public RouteCategories getName() {
        return name;
    }

    public void setName(RouteCategories name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
