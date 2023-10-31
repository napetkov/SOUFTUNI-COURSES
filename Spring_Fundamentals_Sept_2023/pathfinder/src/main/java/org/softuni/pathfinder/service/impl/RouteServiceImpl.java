package org.softuni.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.pathfinder.models.Category;
import org.softuni.pathfinder.models.Route;
import org.softuni.pathfinder.models.User;
import org.softuni.pathfinder.models.dto.binding.AddRouteBidingModel;
import org.softuni.pathfinder.reposritory.CategoryRepository;
import org.softuni.pathfinder.reposritory.RouteRepository;
import org.softuni.pathfinder.service.RouteService;
import org.softuni.pathfinder.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final UserService userService;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, UserService userService, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.userService = userService;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(AddRouteBidingModel addRouteBidingModel) {
        Route route = modelMapper.map(addRouteBidingModel, Route.class);
        route.getCategories().clear();

        Set<Category> categories = categoryRepository.findAllByNameIn(addRouteBidingModel.getCategories());
        route.addCategories(categories);

        User user = userService.getLoggedUser();
        route.setAuthor(user);

        routeRepository.save(route);
    }
}
