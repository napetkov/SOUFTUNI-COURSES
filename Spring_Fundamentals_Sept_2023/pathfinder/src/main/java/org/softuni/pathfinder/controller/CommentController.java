package org.softuni.pathfinder.controller;

import org.softuni.pathfinder.models.dto.binding.CreateCommentBindingModel;
import org.softuni.pathfinder.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ModelAndView create(CreateCommentBindingModel createCommentBindingModel){
        commentService.create(createCommentBindingModel);

        return new ModelAndView("redirect:/routes/details/" + createCommentBindingModel.getRouteId());
    }
}
