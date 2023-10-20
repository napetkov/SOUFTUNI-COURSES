package com.plannerapp.controller;

import com.plannerapp.model.dto.user.UserLoginBindingModel;
import com.plannerapp.model.dto.user.UserRegisterBidingModel;
import com.plannerapp.service.LoggedUser;
import com.plannerapp.service.UserService;
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
    public ModelAndView login(@ModelAttribute("userLoginBidingModel") @Valid UserLoginBindingModel userLoginBindingModel){
        if(loggedUser.isLogged()){
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginBidingModel") @Valid UserLoginBindingModel userLoginBindingModel,
                              BindingResult bindingResult){
        if(loggedUser.isLogged()){
            return new ModelAndView("redirect:/home");
        }
        if(bindingResult.hasErrors()){
            return new ModelAndView("login");
        }

        boolean hasSuccessfulLogin = userService.login(userLoginBindingModel);

        String view;

        if (!hasSuccessfulLogin){
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("hasLoginError",true);
            return modelAndView;
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBidingModel") UserRegisterBidingModel userRegisterBidingModel){
        if(loggedUser.isLogged()){
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBidingModel") @Valid UserRegisterBidingModel userRegisterBidingModel,
                                 BindingResult bindingResult) {
        if(loggedUser.isLogged()){
            return new ModelAndView("redirect:/home");
        }
        if(bindingResult.hasErrors()){
            return new ModelAndView("register");
        }

        boolean hasSuccessfulRegistration = userService.register(userRegisterBidingModel);

        String view;
        if (!hasSuccessfulRegistration){
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.addObject("hasRegistrationError",true);
            return modelAndView;
        }

        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/logout")
    public ModelAndView login(){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");
        }
        userService.logout();

        return new ModelAndView("redirect:/");
    }

}
