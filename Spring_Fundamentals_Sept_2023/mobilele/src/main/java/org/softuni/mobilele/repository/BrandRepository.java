package org.softuni.mobilele.repository;

import org.softuni.mobilele.model.entity.BrandEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
    @Override
    List<BrandEntity> findAll(Sort sort);

    @EntityGraph(
            value = "brandWithModels",
            attributePaths = "models"
    )
    @Query("SELECT b FROM BrandEntity b")
    List<BrandEntity> getAllBrands();
}
