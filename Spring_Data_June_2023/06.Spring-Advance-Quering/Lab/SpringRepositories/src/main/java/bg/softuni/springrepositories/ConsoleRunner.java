package bg.softuni.springrepositories;

import bg.softuni.springrepositories.services.IngredientService;
import bg.softuni.springrepositories.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private ShampooService shampooService;
    private IngredientService ingredientService;

    public ConsoleRunner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {

//        List<Shampoo> byBrand = shampooService.findByBrand("Swiss Green Apple & Nettle");

//        List<Shampoo> byBrandAndSize = shampooService.findByBrandAndSize("Swiss Green Apple & Nettle",Size.SMALL);
//
//        byBrandAndSize.forEach(System.out::println);

//        List<Shampoo> bySize = shampooService.findBySizeOrderedById(Size.MEDIUM);
//
//        bySize.forEach(Shampoo::printShampoo);

//        List<Shampoo> result = shampooService.findBySizeAndLabel(Size.MEDIUM, 10);

//        List<Shampoo> result = shampooService.findByPriceGreaterThanOrderByPriceDesc(BigDecimal.valueOf(2));

//        List<Ingredient> result = ingredientService.findByNameWith("M");

//            List<Ingredient> result = ingredientService.findByNameWithin(List.of("Lavender", "Herbs", "Apple"));

//        long countOfShampoos = shampooService.countOfShampoosWithLowerPriceThan(BigDecimal.valueOf(8.50));
//        List<Shampoo> result = shampooService.findAllWithIngredients(List.of("Lavender", "Herbs", "Apple"));

//        ingredientService.increasePrice();

          ingredientService.deleteIngredientByName("Apple");


//        result.forEach(Shampoo::printShampoo);
//        System.out.println(countOfShampoos);
    }
}
