package bg.softuni.quickfsdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestController {
    @GetMapping("/example/{param}")
    public String exampleEndpoint(@PathVariable String param) {
        return "Received param: " + param;
    }
}
