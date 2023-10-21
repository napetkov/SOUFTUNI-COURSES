package com.likebookapp.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {
    @Column(nullable = false)
    @Length(min = 2, max = 150)
    private String content;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> userLikes;
    @ManyToOne
    @NotNull
    private Mood mood;

    public String getContent() {
        return content;
    }

    public Post setContent(String content) {
        this.content = content;
        return this;
    }

    public User getCreator() {
        return creator;
    }

    public Post setCreator(User creator) {
        this.creator = creator;
        return this;
    }


    public Mood getMood() {
        return mood;
    }

    public Post setMood(Mood mood) {
        this.mood = mood;
        return this;
    }

    public Set<User> getUserLikes() {
        return userLikes;
    }

    public Post setUserLikes(Set<User> userLikes) {
        this.userLikes = userLikes;
        return this;
    }
}
