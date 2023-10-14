package org.softuni.pathfinder.reposritory;

import org.softuni.pathfinder.models.Category;
import org.softuni.pathfinder.models.enums.CategoryNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Set<Category> findAllByNameIn(Set<CategoryNames> categories);
}
