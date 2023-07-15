package bg.softuni.jsonxsmlexercise.services.seed;

import bg.softuni.jsonxsmlexercise.domein.entities.Category;
import bg.softuni.jsonxsmlexercise.domein.entities.Product;
import bg.softuni.jsonxsmlexercise.domein.entities.User;
import bg.softuni.jsonxsmlexercise.domein.models.CategoryImportModel;
import bg.softuni.jsonxsmlexercise.domein.models.ProductImportModel;
import bg.softuni.jsonxsmlexercise.domein.models.UserImportModel;
import bg.softuni.jsonxsmlexercise.repositories.CategoryRepository;
import bg.softuni.jsonxsmlexercise.repositories.ProductRepository;
import bg.softuni.jsonxsmlexercise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static bg.softuni.jsonxsmlexercise.constant.Paths.*;
import static bg.softuni.jsonxsmlexercise.constant.Utils.GSON;
import static bg.softuni.jsonxsmlexercise.constant.Utils.MAPPER;

@Service
public class SeedServiceImpl implements SeedService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void seedUsers() throws IOException {
        if (this.userRepository.count() > 0) return;

        FileReader fileReader = new FileReader(USERS_JSON_PATH.toFile());

        final List<User> usersToSave = Arrays.stream(GSON.fromJson(fileReader, UserImportModel[].class))
                .map(userImportModel -> MAPPER.map(userImportModel, User.class))
                .toList();

        userRepository.saveAll(usersToSave);

        fileReader.close();
    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryRepository.count() > 0) return;

        final FileReader fileReader = new FileReader(CATEGORIES_JSON_PATH.toFile());

        List<Category> categoriesToSave = Arrays.stream(GSON.fromJson(fileReader, CategoryImportModel[].class))
                .map(categoryImportModel -> MAPPER.map(categoryImportModel, Category.class))
                .toList();

        this.categoryRepository.saveAll(categoriesToSave);

        fileReader.close();
    }

    @Override
    public void seedProducts() throws IOException {
        if (this.productRepository.count() > 0) return;

        FileReader fileReader = new FileReader(PRODUCTS_JSON_PATH.toFile());

        List<Product> productsToSave = Arrays.stream(GSON.fromJson(fileReader, ProductImportModel[].class))
                .map(productImportModel -> MAPPER.map(productImportModel, Product.class))
                .map(this::setRandomCategories)
                .map(this::setRandomBuyer)
                .map(this::setRandomSeller)
                .toList();

        this.productRepository.saveAll(productsToSave);

        fileReader.close();
    }

    private Product setRandomSeller(Product product) {

        User seller = this.userRepository
                .getRandomEntity()
                .orElseThrow(NoSuchElementException::new);

        while (product.getBuyer() != null && Objects.equals(seller.getId(), product.getBuyer().getId())) {

            seller = this.userRepository
                    .getRandomEntity()
                    .orElseThrow(NoSuchElementException::new);
        }

        product.setSeller(seller);

        return product;
    }

    private Product setRandomBuyer(Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(750L)) >= 0) {

            User buyer = this.userRepository
                    .getRandomEntity()
                    .orElseThrow(NoSuchElementException::new);

            product.setBuyer(buyer);
        }
        return product;
    }

    private Product setRandomCategories(Product product) {
        final Random random = new Random();

        Long countOfCategories = random.nextLong(this.categoryRepository.count());

        Set<Category> categories = new HashSet<>();

        LongStream.range(0, countOfCategories)
                .forEach(value -> {
                    categories.add(this.categoryRepository
                            .getRandomEntity()
                            .orElseThrow(NoSuchElementException::new));
                });

        product.setCategories(categories);

        return product;
    }
}
