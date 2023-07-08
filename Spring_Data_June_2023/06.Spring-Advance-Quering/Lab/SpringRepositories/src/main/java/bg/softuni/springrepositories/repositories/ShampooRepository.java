package bg.softuni.springrepositories.repositories;


import bg.softuni.springrepositories.entities.Shampoo;
import bg.softuni.springrepositories.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo,Long> {
    List<Shampoo> findAllByBrand(String brand);
    List<Shampoo> findAllByBrandAndSize(String brand, Size size);


    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabelIdOrderByPrice(Size size, long id);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    long countByPriceLessThan(BigDecimal price);

    @Query(value = "SELECT s " +
            "FROM Shampoo AS s " +
            "JOIN s.ingredients as i " +
            "WHERE i.name in :names")
    List<Shampoo> findByIngredientsNameIn(@Param(value = "names") List<String> ingredientsNames);
}
