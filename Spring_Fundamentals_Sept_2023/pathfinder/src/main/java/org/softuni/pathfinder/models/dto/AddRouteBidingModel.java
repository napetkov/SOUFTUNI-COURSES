package org.softuni.pathfinder.models.dto;

import org.softuni.pathfinder.models.enums.CategoryNames;
import org.softuni.pathfinder.models.enums.Level;

import java.util.Set;

public class AddRouteBidingModel {
    private String name;
    private String description;
    private Level level;
    private String videoUrl;
    private Set<CategoryNames> categories;

    public String getName() {
        return name;
    }

    public AddRouteBidingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddRouteBidingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public AddRouteBidingModel setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public AddRouteBidingModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<CategoryNames> getCategories() {
        return categories;
    }

    public AddRouteBidingModel setCategories(Set<CategoryNames> categories) {
        this.categories = categories;
        return this;
    }
}
