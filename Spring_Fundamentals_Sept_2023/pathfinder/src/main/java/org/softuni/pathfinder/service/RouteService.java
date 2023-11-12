package org.softuni.pathfinder.service;

import org.softuni.pathfinder.models.dto.binding.AddRouteBidingModel;
import org.softuni.pathfinder.models.dto.binding.UploadPictureRouteBindingModel;
import org.softuni.pathfinder.models.dto.view.RouteCategoryViewModel;
import org.softuni.pathfinder.models.dto.view.RouteDetailViewModel;
import org.softuni.pathfinder.models.dto.view.RouteViewModel;
import org.softuni.pathfinder.models.enums.CategoryNames;

import java.util.List;

public interface RouteService {

    void add(AddRouteBidingModel addRouteBidingModel);

    List <RouteViewModel> getAll();

    RouteDetailViewModel getDetails(Long id);

    void uploadPicture(UploadPictureRouteBindingModel uploadPictureRouteBindingModel);

    List<RouteCategoryViewModel> getAllByCategory(CategoryNames categoryName);
}
