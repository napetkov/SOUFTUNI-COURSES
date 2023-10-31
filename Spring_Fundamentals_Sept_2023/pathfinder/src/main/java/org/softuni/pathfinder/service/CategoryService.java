package org.softuni.pathfinder.service;

import org.softuni.pathfinder.models.Category;
import org.softuni.pathfinder.models.enums.CategoryNames;

import java.util.Set;

public interface CategoryService {
    Set<Category> findAllByNameIn(Set<CategoryNames> categoryNames);
}
