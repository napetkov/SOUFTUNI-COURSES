package org.softuni.pathfinder.service;

import org.softuni.pathfinder.models.dto.binding.CreateCommentBindingModel;

public interface CommentService {
    void create(CreateCommentBindingModel createCommentBindingModel);
}
