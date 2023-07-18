package bg.softuni.jsonxsmlexercise;

import bg.softuni.jsonxsmlexercise.services.UserService;
import bg.softuni.jsonxsmlexercise.services.category.CategoryService;
import bg.softuni.jsonxsmlexercise.services.product.ProductService;
import bg.softuni.jsonxsmlexercise.services.seed.SeedService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class ConsoleRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final ProductService productService;

    private final UserService userService;

    private final CategoryService categoryService;

    public ConsoleRunner(SeedService seedService, ProductService productService, UserService userService, CategoryService categoryService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedService.seedAll("XML");

        productService.productsInRangeWithNoBuyer(BigDecimal.valueOf(500),BigDecimal.valueOf(1000));

        userService.getUsersAndSoldProducts();

        categoryService.getCategorySummery();

        userService.getUsersAndSoldProductsWrapper();

    }
}
