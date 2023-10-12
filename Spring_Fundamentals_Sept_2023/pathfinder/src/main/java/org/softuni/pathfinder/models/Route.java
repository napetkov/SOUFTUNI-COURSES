package org.softuni.pathfinder.models;

import jakarta.persistence.*;
import org.softuni.pathfinder.models.enums.Level;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{
    @Column(name = "description",columnDefinition = "TEXT")
    private String description;
    @Column(name = "gpx_coordinates",columnDefinition = "LONGTEXT")
    private String gpxCoordinates;
    @Enumerated(EnumType.STRING)
    private Level level;
    @Column(name = "name",nullable = false)
    private String name;
    @ManyToOne
    private User author;
    @Column(name = "video_url")
    private String videoUrl;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "routes_categories",
            joinColumns = @JoinColumn(name = "route_entity_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id",referencedColumnName = "id")
    )
    private Set<Category> categories;

    public Route() {
        this.categories = new HashSet<>();
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
