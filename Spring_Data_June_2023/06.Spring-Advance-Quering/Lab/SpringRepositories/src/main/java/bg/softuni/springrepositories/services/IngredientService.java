package bg.softuni.springrepositories.services;

import bg.softuni.springrepositories.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findByNameWith(String letter);

    List<Ingredient> findByNameWithin(List<String> names);

    void increasePrice();

    void deleteIngredientByName(String name);
}
