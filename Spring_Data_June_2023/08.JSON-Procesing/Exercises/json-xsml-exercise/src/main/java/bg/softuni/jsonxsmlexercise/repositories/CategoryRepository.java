package bg.softuni.jsonxsmlexercise.repositories;

import bg.softuni.jsonxsmlexercise.domein.entities.Category;
import bg.softuni.jsonxsmlexercise.domein.models.category.CategorySummeryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "select *  from `json-xml-exercise`.categories order by RAND() LIMIT 1",nativeQuery = true)
    Optional<Category> getRandomEntity();

    @Query(value = "SELECT new bg.softuni.jsonxsmlexercise.domein.models.category.CategorySummeryDTO (c.name, count (p.id), avg (p.price), sum(p.price)) " +
            "FROM Product p join p.categories c group by c.id ")
    List<CategorySummeryDTO> getCategorySummery();

}
