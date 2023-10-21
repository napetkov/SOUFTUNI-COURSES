package com.likebookapp.service;

import com.likebookapp.model.dto.post.PostAddBindingModel;
import com.likebookapp.model.dto.post.PostHomeViewModel;

public interface PostService {
    void add(PostAddBindingModel postAddBindingModel);

    PostHomeViewModel getHomeViewModel(String username);

    void remove(Long id);

    void like(Long id, String username);
}
