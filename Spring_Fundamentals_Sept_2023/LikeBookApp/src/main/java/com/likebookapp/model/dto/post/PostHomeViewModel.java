package com.likebookapp.model.dto.post;

import java.util.ArrayList;
import java.util.List;

public class PostHomeViewModel {
    List<PostDTO> myPosts;
    List<PostDTO> otherPosts;

    public PostHomeViewModel() {
        this(new ArrayList<>(),new ArrayList<>());
    }

    public PostHomeViewModel(List<PostDTO> myPosts, List<PostDTO> otherPosts) {
        this.myPosts = myPosts;
        this.otherPosts = otherPosts;
    }

    public List<PostDTO> getMyPosts() {
        return myPosts;
    }

    public PostHomeViewModel setMyPosts(List<PostDTO> myPosts) {
        this.myPosts = myPosts;
        return this;
    }

    public List<PostDTO> getOtherPosts() {
        return otherPosts;
    }

    public PostHomeViewModel setOtherPosts(List<PostDTO> otherPosts) {
        this.otherPosts = otherPosts;
        return this;
    }
}
