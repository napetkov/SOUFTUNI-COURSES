package bg.softuni.jsonxsmlexercise.services.seed;

import bg.softuni.jsonxsmlexercise.domein.entities.Category;
import bg.softuni.jsonxsmlexercise.domein.entities.Product;
import bg.softuni.jsonxsmlexercise.domein.entities.User;
import bg.softuni.jsonxsmlexercise.domein.models.category.CategoryImportModel;
import bg.softuni.jsonxsmlexercise.domein.models.category.wrappers.CategoryWrapperImportModel;
import bg.softuni.jsonxsmlexercise.domein.models.product.ProductImportModel;
import bg.softuni.jsonxsmlexercise.domein.models.product.wrappers.ProductWrapperImportModel;
import bg.softuni.jsonxsmlexercise.domein.models.user.UserImportModel;
import bg.softuni.jsonxsmlexercise.domein.models.user.wrappers.UserWrapperImportModel;
import bg.softuni.jsonxsmlexercise.repositories.CategoryRepository;
import bg.softuni.jsonxsmlexercise.repositories.ProductRepository;
import bg.softuni.jsonxsmlexercise.repositories.UserRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
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
    public void seedUsers(String type) throws IOException, JAXBException {
        if (this.userRepository.count() > 0) return;

        List<User> usersToSave = type.equals("JSON")
                ? getAllUsersFromJson()
                : getAllUsersFromXml();


        userRepository.saveAll(usersToSave);

    }

    @Override
    public void seedCategories(String type) throws IOException, JAXBException {
        if (this.categoryRepository.count() > 0) return;

        final List<Category> categoriesToSave = type.equals("JSON")
                ? getAllCategoriesFromJson()
                : getAllCategoriesFromXml();

        this.categoryRepository.saveAll(categoriesToSave);
    }

    @Override
    public void seedProducts(String type) throws IOException, JAXBException {
        if (this.productRepository.count() > 0) return;

       final List<Product> productsBeforeMap = type.equals("JSON")
                ? getAllProductsFromJson()
                : getAllProductsFromXml();

        final List<Product> productsToSave = productsBeforeMap.stream()
                .map(this::setRandomCategories)
                .map(this::setRandomBuyer)
                .map(this::setRandomSeller)
                .toList();

        this.productRepository.saveAll(productsToSave);
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

    private List<Category> getAllCategoriesFromJson() throws IOException {

        final FileReader fileReader = new FileReader(CATEGORIES_JSON_PATH.toFile());

        List<Category> categories = Arrays.stream(GSON.fromJson(fileReader, CategoryImportModel[].class))
                .map(categoryImportModel -> MAPPER.map(categoryImportModel, Category.class))
                .toList();

        fileReader.close();

        return categories;
    }

    private List<Category> getAllCategoriesFromXml() throws IOException, JAXBException {

        final FileReader fileReader = new FileReader(CATEGORIES_XML_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(CategoryWrapperImportModel.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        CategoryWrapperImportModel wrapperImportModel = (CategoryWrapperImportModel) unmarshaller.unmarshal(fileReader);

        fileReader.close();

        List<Category> categories = wrapperImportModel.getCategories()
                .stream().map(categoryImportModel -> MAPPER.map(categoryImportModel, Category.class))
                .toList();

        return categories;
    }

    private List<User> getAllUsersFromJson() throws IOException {

        FileReader fileReader = new FileReader(USERS_JSON_PATH.toFile());

        final List<User> usersToSave = Arrays.stream(GSON.fromJson(fileReader, UserImportModel[].class))
                .map(userImportModel -> MAPPER.map(userImportModel, User.class))
                .toList();

        fileReader.close();

        return usersToSave;
    }

    private List<User> getAllUsersFromXml() throws IOException, JAXBException {

        final FileReader fileReader = new FileReader(USERS_XML_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(UserWrapperImportModel.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        UserWrapperImportModel wrapperImportModel = (UserWrapperImportModel) unmarshaller.unmarshal(fileReader);

        fileReader.close();

        return wrapperImportModel.getUsers()
                .stream().map(userImportModel -> MAPPER.map(userImportModel, User.class))
                .toList();
    }

    private List<Product> getAllProductsFromJson() throws IOException {

        FileReader fileReader = new FileReader(PRODUCTS_JSON_PATH.toFile());

        List<Product> productsToSave = Arrays.stream(GSON.fromJson(fileReader, ProductImportModel[].class))
                .map(productImportModel -> MAPPER.map(productImportModel, Product.class))
                .toList();

        fileReader.close();

        return productsToSave;
    }

    private List<Product> getAllProductsFromXml() throws IOException, JAXBException {

        final FileReader fileReader = new FileReader(PRODUCTS_XML_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(ProductWrapperImportModel.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        ProductWrapperImportModel wrapperImportModel = (ProductWrapperImportModel) unmarshaller.unmarshal(fileReader);

        fileReader.close();

        return wrapperImportModel.getProducts()
                .stream().map(productImportModel -> MAPPER.map(productImportModel, Product.class))
                .toList();
    }
}
