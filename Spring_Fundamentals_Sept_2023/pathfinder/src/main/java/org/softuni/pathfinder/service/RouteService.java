package org.softuni.pathfinder.service;

import org.softuni.pathfinder.models.dto.binding.AddRouteBidingModel;
import org.softuni.pathfinder.models.dto.view.RoutesGetAllViewModel;

import java.util.List;

public interface RouteService {

    void add(AddRouteBidingModel addRouteBidingModel);

    List <RoutesGetAllViewModel> getAll();
}
