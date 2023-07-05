package bg.softuni.bookshop.repositories;

import bg.softuni.bookshop.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//creating the repository interface will create table in database regrading the given Entity
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
