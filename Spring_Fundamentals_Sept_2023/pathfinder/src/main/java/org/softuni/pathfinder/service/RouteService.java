package org.softuni.pathfinder.service;

import org.softuni.pathfinder.models.dto.binding.AddRouteBidingModel;
import org.softuni.pathfinder.models.dto.view.RouteDetailViewModel;
import org.softuni.pathfinder.models.dto.view.RouteViewModel;

import java.util.List;

public interface RouteService {

    void add(AddRouteBidingModel addRouteBidingModel);

    List <RouteViewModel> getAll();

    RouteDetailViewModel getDetails(Long id);
}
