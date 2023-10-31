package org.softuni.pathfinder.models.dto.view;

public class RouteCategoryViewModel {
    private long id;
    private String title;
    private String description;

    public RouteCategoryViewModel() {
    }

    public long getId() {
        return id;
    }

    public RouteCategoryViewModel setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public RouteCategoryViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteCategoryViewModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
