package com.likebookapp.model.dto.post;

import com.likebookapp.model.entity.Post;
import com.likebookapp.model.enums.MoodName;

public class PostDTO {
    private Long id;
    private String mood;
    private String content;
    private String creatorUsername;
    private int likes;

    public Long getId() {
        return id;
    }

    public PostDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMood() {
        return mood;
    }

    public PostDTO setMood(String mood) {
        this.mood = mood;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostDTO setContent(String content) {
        this.content = content;
        return this;
    }

    public int getLikes() {
        return likes;
    }

    public PostDTO setLikes(int likes) {
        this.likes = likes;
        return this;
    }

    public String getCreatorUsername() {
        return creatorUsername;
    }

    public PostDTO setCreatorUsername(String creatorUsername) {
        this.creatorUsername = creatorUsername;
        return this;
    }

    public static PostDTO createFromPost(Post post){
        return new PostDTO()
                .setId(post.getId())
                .setContent(post.getContent())
                .setMood(post.getMood().getName().toString())
                .setCreatorUsername(post.getCreator().getUsername())
                .setLikes(post.getUserLikes().size());
    }
}
