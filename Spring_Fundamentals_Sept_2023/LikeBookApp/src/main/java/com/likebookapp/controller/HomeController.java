package com.likebookapp.controller;

import com.likebookapp.model.dto.post.PostHomeViewModel;
import com.likebookapp.service.LoggedUser;
import com.likebookapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private final PostService postService;
    private final LoggedUser loggedUser;

    public HomeController(PostService postService, LoggedUser loggedUser) {
        this.postService = postService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
    public ModelAndView index(){
        if(loggedUser.isLogged()){
           return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home(){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");
        }

        PostHomeViewModel viewModel = postService.getHomeViewModel(loggedUser.getUsername());

        return new ModelAndView("home","posts",viewModel);
    }
}
