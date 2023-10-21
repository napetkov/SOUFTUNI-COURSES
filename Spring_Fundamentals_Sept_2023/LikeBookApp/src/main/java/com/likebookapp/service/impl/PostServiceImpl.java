package com.likebookapp.service.impl;

import com.likebookapp.model.dto.post.PostAddBindingModel;
import com.likebookapp.model.dto.post.PostDTO;
import com.likebookapp.model.dto.post.PostHomeViewModel;
import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.LoggedUser;
import com.likebookapp.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final MoodRepository moodRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final LoggedUser loggedUser;


    public PostServiceImpl(MoodRepository moodRepository, UserRepository userRepository, PostRepository postRepository, LoggedUser loggedUser) {
        this.moodRepository = moodRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public void add(PostAddBindingModel postAddBindingModel) {
        Mood mood = moodRepository.findByName(postAddBindingModel.getMood());
        User user = userRepository.findByUsername(loggedUser.getUsername());

        if (mood != null && user != null) {
            Post post = new Post();
            post.setContent(postAddBindingModel.getContent())
                    .setMood(mood)
                    .setCreator(user);

            postRepository.save(post);
        }

    }

    @Override
    public PostHomeViewModel getHomeViewModel(String username) {
        User user = userRepository.findByUsername(username);

        List<PostDTO> myPosts =postRepository.findByCreator(user)
                .stream().map(PostDTO::createFromPost)
                .collect(Collectors.toList());

        List<PostDTO> otherPosts = postRepository.findAllOtherPosts(user)
                .stream().map(PostDTO::createFromPost)
                .collect(Collectors.toList());


        return new PostHomeViewModel(myPosts,otherPosts);
    }

    @Override
    public void remove(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void like(Long id, String username) {
        User user = userRepository.findByUsername(username);

        Optional<Post> optionalPost = postRepository.findById(id);

        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            post.getUserLikes().add(user);

            postRepository.save(post);
        }
    }
}
