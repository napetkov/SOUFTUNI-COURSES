package com.resellerapp.controller;

import com.resellerapp.model.UserLoginBidingModel;
import com.resellerapp.model.UserRegisterBindingModel;
import com.resellerapp.service.LoggedUser;
import com.resellerapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;
    private final LoggedUser loggedUser;

    public UserController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }


    @GetMapping("/login")
    public ModelAndView login(){
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("/login");
    }

    @PostMapping("/login")
    public ModelAndView login(
            @Valid @ModelAttribute("userLoginBidingModel") UserLoginBidingModel userLoginBidingModel,
            BindingResult bindingResult){

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }
//        TODO: implement validation
        boolean hasErrors = bindingResult.hasErrors();

        boolean isLogged = this.userService.login(userLoginBidingModel);
        String view = isLogged ? "redirect:/home" : "login";

        return new ModelAndView(view);
    }

    @GetMapping("/register")
    public ModelAndView register(){
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("/register");
    }

    @PostMapping("/register")
    public ModelAndView register(UserRegisterBindingModel userRegisterBindingModel){
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }
        boolean isRegistered = userService.register(userRegisterBindingModel);

        String view = isRegistered ? "redirect:/login" : "register";

        return new ModelAndView(view);
    }

    @PostMapping("/logout")
    public ModelAndView logout(){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }
        userService.logout();
        return new ModelAndView("redirect:/");
    }
}
