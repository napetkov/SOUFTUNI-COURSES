package org.softuni.pathfinder.controller;

import org.softuni.pathfinder.models.dto.binding.UserLoginBidingModel;
import org.softuni.pathfinder.models.dto.binding.UserRegisterBindingModel;
import org.softuni.pathfinder.models.dto.view.UserProfileViewModel;
import org.softuni.pathfinder.service.AuthenticationService;
import org.softuni.pathfinder.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    public UsersController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(UserLoginBidingModel userLoginBidingModel){
     boolean isLogged  = authenticationService.login(userLoginBidingModel);

     if(isLogged){
         return new ModelAndView("redirect:/");
     }

     return new ModelAndView("/login");
    }

    @GetMapping("/register")
    public ModelAndView register(){

        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(UserRegisterBindingModel userRegisterBindingModel){

        authenticationService.register(userRegisterBindingModel);

        return new ModelAndView("redirect:login");
    }

    @PostMapping("/logout")
    public ModelAndView logout(){
        this.authenticationService.logout();
        return new ModelAndView("redirect:login");
    }

    @GetMapping("profile")
    public ModelAndView profile(){
        UserProfileViewModel userProfileViewModel = userService.getUserProfile();

        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("userProfileViewModel",userProfileViewModel);

        return modelAndView;
    }
}
