package com.likebookapp.model.entity;

import com.likebookapp.model.enums.MoodName;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "moods")
public class Mood extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private MoodName name;
    private String description;
    @OneToMany(mappedBy = "mood")
    private Set<Post> posts;

    public Set<Post> getPosts() {
        return posts;
    }

    public Mood setPosts(Set<Post> posts) {
        this.posts = posts;
        return this;
    }

    public MoodName getName() {
        return name;
    }

    public Mood setName(MoodName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Mood setDescription(String description) {
        this.description = description;
        return this;
    }
}
