package bg.softuni.springrepositories.services;

import bg.softuni.springrepositories.entities.Shampoo;
import bg.softuni.springrepositories.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {

    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findByBrandAndSize(String brand, Size size);

    List<Shampoo> findBySizeOrderedById(Size size);

    List<Shampoo> findBySizeAndLabel(Size size, long id);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    long countOfShampoosWithLowerPriceThan(BigDecimal price);

    List<Shampoo> findAllWithIngredients(List<String> ingredientsNames);
}
