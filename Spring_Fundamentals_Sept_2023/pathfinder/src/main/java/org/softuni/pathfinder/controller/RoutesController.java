package org.softuni.pathfinder.controller;

import org.softuni.pathfinder.models.dto.binding.AddRouteBidingModel;
import org.softuni.pathfinder.models.dto.view.RouteViewModel;
import org.softuni.pathfinder.models.enums.CategoryNames;
import org.softuni.pathfinder.models.enums.Level;
import org.softuni.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/routes")
public class RoutesController {
    private final RouteService routeService;

    public RoutesController(RouteService routeService) {
        this.routeService = routeService;
    }


    @GetMapping
    public ModelAndView getAll() {
        List<RouteViewModel> routes = routeService.getAll();

        ModelAndView modelAndView = new ModelAndView("routes");
        modelAndView.addObject("routes", routes);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addRoute() {
        ModelAndView modelAndView = new ModelAndView("add-route");

        modelAndView.addObject("levels", Level.values());
        modelAndView.addObject("categories", CategoryNames.values());

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addRoute(AddRouteBidingModel addRouteBidingModel) {
        routeService.add(addRouteBidingModel);

        return new ModelAndView("redirect:/");
    }


}
