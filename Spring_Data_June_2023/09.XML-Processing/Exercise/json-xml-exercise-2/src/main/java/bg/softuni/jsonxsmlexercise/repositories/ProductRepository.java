package bg.softuni.jsonxsmlexercise.repositories;

import bg.softuni.jsonxsmlexercise.domein.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal lowBoundary,BigDecimal highBoundary);
}
