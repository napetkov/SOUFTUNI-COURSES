package org.softuni.pathfinder.models.dto.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.softuni.pathfinder.models.User;
import org.softuni.pathfinder.models.enums.CategoryNames;
import org.softuni.pathfinder.models.enums.Level;

import java.util.Set;

public class AddRouteBidingModel {
    @Size(min = 3, message = "Name length must be more than 3 characters")
    private String name;
    @Size(min = 5, message = "Description length must be more than 5 characters!")
    private String description;
    private Level level;
    private String videoUrl;
    private User author;
    private Set<CategoryNames> categories;

    public User getAuthor() {
        return author;
    }

    public AddRouteBidingModel setAuthor(User author) {
        this.author = author;
        return this;
    }

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
