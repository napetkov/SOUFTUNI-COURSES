package bg.softuni.jsonxsmlexercise.services.seed;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SeedService {
    void seedUsers() throws IOException;
    void seedCategories() throws IOException;
    void seedProducts() throws FileNotFoundException, IOException;

    default void seedAll() throws IOException {
        seedUsers();
        seedCategories();
        seedProducts();
    }
}
