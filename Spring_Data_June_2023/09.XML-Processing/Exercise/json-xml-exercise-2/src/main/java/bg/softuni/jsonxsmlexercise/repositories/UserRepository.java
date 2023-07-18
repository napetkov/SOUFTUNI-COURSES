package bg.softuni.jsonxsmlexercise.repositories;

import bg.softuni.jsonxsmlexercise.domein.entities.Category;
import bg.softuni.jsonxsmlexercise.domein.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "select *  from `json-xml-exercise`.users order by RAND() LIMIT 1",nativeQuery = true)
    Optional<User> getRandomEntity();


    List<User> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastNameAscSellingProductsBuyerFirstName();
//    List<User> findAllBySellingProductsBuyerIsNotNullOrderByCountSellingProductsDescSellingProductsBuyerLastName();

}

