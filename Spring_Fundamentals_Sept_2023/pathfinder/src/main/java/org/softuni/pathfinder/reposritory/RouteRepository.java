package org.softuni.pathfinder.reposritory;

import org.softuni.pathfinder.models.Category;
import org.softuni.pathfinder.models.Route;
import org.softuni.pathfinder.models.dto.view.RouteCategoryViewModel;
import org.softuni.pathfinder.models.enums.CategoryNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {
    List<Route> findAllByCategories_Name(CategoryNames categoryNames);
}
