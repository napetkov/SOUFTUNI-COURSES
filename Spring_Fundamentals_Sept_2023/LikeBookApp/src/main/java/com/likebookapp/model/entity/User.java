package com.likebookapp.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(unique = true,nullable = false)
    @Length(min = 3,max = 20)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(unique = true,nullable = false)
    private String email;
    @OneToMany(mappedBy = "creator")
    private Set<Post> posts;
    @ManyToMany(mappedBy = "userLikes",fetch = FetchType.EAGER)
    private Set<Post> likedPost;

    public Set<Post> getPosts() {
        return posts;
    }

    public User setPosts(Set<Post> posts) {
        this.posts = posts;
        return this;
    }

    public Set<Post> getLikedPost() {
        return likedPost;
    }

    public User setLikedPost(Set<Post> likedPost) {
        this.likedPost = likedPost;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
}
