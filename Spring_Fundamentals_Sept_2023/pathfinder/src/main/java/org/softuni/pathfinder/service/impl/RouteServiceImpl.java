package org.softuni.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.pathfinder.exceptions.RouteNotFoundException;
import org.softuni.pathfinder.models.Category;
import org.softuni.pathfinder.models.Route;
import org.softuni.pathfinder.models.User;
import org.softuni.pathfinder.models.dto.binding.AddRouteBidingModel;
import org.softuni.pathfinder.models.dto.view.RouteDetailViewModel;
import org.softuni.pathfinder.models.dto.view.RouteViewModel;
import org.softuni.pathfinder.reposritory.CategoryRepository;
import org.softuni.pathfinder.reposritory.RouteRepository;
import org.softuni.pathfinder.service.RouteService;
import org.softuni.pathfinder.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public List<RouteViewModel> getAll() {
        return routeRepository.findAll()
                .stream()
                .map(route -> modelMapper.map(route, RouteViewModel.class))
                .toList();
    }

    @Override
    public RouteDetailViewModel getDetails(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RouteNotFoundException("Route with id: " + id + " was not found!"));

        return modelMapper.map(route, RouteDetailViewModel.class);
    }

    @Override
    public void add(AddRouteBidingModel addRouteBidingModel) {
        Route route = modelMapper.map(addRouteBidingModel, Route.class);

        String regex = "v=(.*)";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(route.getVideoUrl());

        if(matcher.find()){
            String url= matcher.group(1);
            route.setVideoUrl(url);
        }

        routeRepository.save(route);
    }


}
