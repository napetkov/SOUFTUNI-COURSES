package bg.softuni.springrepositories.services;

import bg.softuni.springrepositories.entities.Shampoo;
import bg.softuni.springrepositories.entities.Size;
import bg.softuni.springrepositories.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {
    private ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findByBrand(String brand) {
        return shampooRepository.findAllByBrand(brand);
    }

    @Override
    public List<Shampoo> findByBrandAndSize(String brand, Size size) {
        return shampooRepository.findAllByBrandAndSize(brand, size);
    }

    @Override
    public List<Shampoo> findBySizeOrderedById(Size size) {
        return shampooRepository.findAllBySizeOrderById(size);

    }

    @Override
    public List<Shampoo> findBySizeAndLabel(Size size, long id) {
       return shampooRepository.findAllBySizeOrLabelIdOrderByPrice(size,id);

    }

    @Override
    public List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price) {
       return shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price);

    }

    @Override
    public long countOfShampoosWithLowerPriceThan(BigDecimal price) {

        return shampooRepository.countByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> findAllWithIngredients(List<String> ingredientsNames) {
        return shampooRepository.findByIngredientsNameIn(ingredientsNames);
    }


}
