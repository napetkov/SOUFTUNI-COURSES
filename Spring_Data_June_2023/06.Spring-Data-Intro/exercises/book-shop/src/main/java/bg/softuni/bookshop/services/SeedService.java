package bg.softuni.bookshop.services;

import java.io.IOException;


//only purpose of this service is to populate the database
public interface SeedService {

    void seedAuthors() throws IOException;

    void seedBooks() throws IOException;

    void seedCategories() throws IOException;


    //default method doesn't need to be overwritten and it will start all seeding methods
    default void seedAllData() throws IOException {
        seedCategories();
        seedAuthors();
        seedBooks();
    }

}
