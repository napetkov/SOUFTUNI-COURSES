package org.softuni.pathfinder.service.impl;

import org.softuni.pathfinder.models.Category;
import org.softuni.pathfinder.models.enums.CategoryNames;
import org.softuni.pathfinder.reposritory.CategoryRepository;
import org.softuni.pathfinder.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> findAllByNameIn(Set<CategoryNames> categoryNames) {
        return categoryRepository.findAllByNameIn(categoryNames);
    }
}
