package bg.softuni.springrepositories.services;

import bg.softuni.springrepositories.entities.Ingredient;
import bg.softuni.springrepositories.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findByNameWith(String letter) {
        return ingredientRepository.findByNameStartingWith(letter);
    }

    @Override
    public List<Ingredient> findByNameWithin(List<String> names) {
        return ingredientRepository.findByNameInOrderByPriceAsc(names);
    }

    @Override
    public void increasePrice() {
        ingredientRepository.increasePriceBy10Percent();
    }

    @Override
    public void deleteIngredientByName(String name) {
        ingredientRepository.deleteIngredientByName(name);
    }


}
