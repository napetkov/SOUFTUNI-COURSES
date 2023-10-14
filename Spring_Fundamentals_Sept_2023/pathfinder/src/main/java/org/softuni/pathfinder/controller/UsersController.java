package org.softuni.pathfinder.controller;

import org.softuni.pathfinder.models.dto.UserLoginBidingModel;
import org.softuni.pathfinder.models.dto.UserRegisterBindingModel;
import org.softuni.pathfinder.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final AuthenticationService authenticationService;

    public UsersController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
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

    //TODO: change to POST
    @GetMapping("/logout")
    public ModelAndView logout(){
        this.authenticationService.logout();
        return new ModelAndView("redirect:login");
    }
}
