package org.softuni.pathfinder.models.controller;

import org.softuni.pathfinder.models.User;
import org.softuni.pathfinder.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Only for test in this example. For MVC @Controller
@RequestMapping("users/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @RequestMapping(path = "/users/all", method = RequestMethod.GET)
    @GetMapping("/all")
    public List<User> getAll(){
        return this.userService.getALL();
    }
}
