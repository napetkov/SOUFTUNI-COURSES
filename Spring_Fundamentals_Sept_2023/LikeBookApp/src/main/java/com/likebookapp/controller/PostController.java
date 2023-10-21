package com.likebookapp.controller;

import com.likebookapp.model.dto.post.PostAddBindingModel;
import com.likebookapp.service.LoggedUser;
import com.likebookapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PostController {
    private final PostService postService;
    private final LoggedUser loggedUser;

    public PostController(PostService postService, LoggedUser loggedUser) {
        this.postService = postService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/posts/add")
    public ModelAndView add(@ModelAttribute("postAddBindingModel") PostAddBindingModel postAddBindingModel) {
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("post-add");
    }

    @PostMapping("/posts/add")
    public ModelAndView add(@ModelAttribute("postAddBindingModel") @Valid PostAddBindingModel postAddBindingModel,
                            BindingResult bindingResult) {
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("post-add");
        }
        postService.add(postAddBindingModel);

        return new ModelAndView("redirect:/home");
    }

    @DeleteMapping("/posts/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");
        }

        postService.remove(id);

        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/posts/like/{id}")
    public ModelAndView like(@PathVariable("id") Long id) {
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");
        }

        postService.like(id,loggedUser.getUsername());

        return new ModelAndView("redirect:/home");
    }
}
