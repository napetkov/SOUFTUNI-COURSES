package bg.softuni.springrepositories.repositories;

import bg.softuni.springrepositories.entities.Ingredient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByNameStartingWith(String letter);
    List<Ingredient> findByNameInOrderByPriceAsc(List<String> names);

    @Modifying
    @Transactional
    @Query("UPDATE Ingredient as i SET i.name = CONCAT(i.name, ' Updated')")
    void increasePriceBy10Percent();

    @Transactional
    void deleteIngredientByName(String name);

}
