package org.softuni.pathfinder.controller;

import org.softuni.pathfinder.models.User;
import org.softuni.pathfinder.service.RestDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Only for test in this example. For MVC @Controller
@RequestMapping("users/")
public class RestDemoController {
    private final RestDemoService restDemoService;

    public RestDemoController(RestDemoService restDemoService) {
        this.restDemoService = restDemoService;
    }

//    @RequestMapping(path = "/users/all", method = RequestMethod.GET)
    @GetMapping("/all")
    public List<User> getAll(){
        return this.restDemoService.getALL();
    }
}
