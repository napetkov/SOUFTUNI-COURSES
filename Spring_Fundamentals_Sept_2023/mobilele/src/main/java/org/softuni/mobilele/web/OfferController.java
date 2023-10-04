package org.softuni.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OfferController {

    @GetMapping("/all")
    public String all(){
        return "/offers";
    }

    @GetMapping("/add")
    public String add(){
        return "/offer-add";
    }

    @GetMapping("/{id}/details")
    public String details(@PathVariable("id") String uuid){
        return "details";
    }
}
