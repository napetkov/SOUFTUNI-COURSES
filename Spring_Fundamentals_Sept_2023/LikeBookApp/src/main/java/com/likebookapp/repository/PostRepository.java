package com.likebookapp.repository;

import com.likebookapp.model.dto.post.PostDTO;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCreator(User user);
    @Query("SELECT p FROM Post p WHERE p.creator != :user")
    List<Post> findAllOtherPosts(@Param("user") User user);
}
