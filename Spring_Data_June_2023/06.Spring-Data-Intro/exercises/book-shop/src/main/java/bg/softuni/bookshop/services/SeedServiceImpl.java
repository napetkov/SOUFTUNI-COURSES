package bg.softuni.bookshop.services;

import bg.softuni.bookshop.domain.entities.Author;
import bg.softuni.bookshop.domain.entities.Book;
import bg.softuni.bookshop.domain.entities.Category;
import bg.softuni.bookshop.domain.enums.AgeRestriction;
import bg.softuni.bookshop.domain.enums.EditionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static bg.softuni.bookshop.constants.FilePath.*;

@Service
public class SeedServiceImpl implements SeedService {
    private final CategoryService categoryService;
    private final AuthorService authorService;

    private final BookService bookService;

    @Autowired
    public SeedServiceImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @Override
    public void seedAuthors() throws IOException {
        if (authorService.isDataSeeded()) return;

        this.authorService.seedAuthors(Files.readAllLines(Path.of(RESOURCE_URL + AUTHOR_FILE_NAME))
                .stream().map(firstAndLastName -> Author.builder()
                        .firstName(firstAndLastName.split(" ")[0])
                        .lastName(firstAndLastName.split(" ")[1])
                        .build())
                .toList());
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookService.isDataSeeded()) return;
        List<Book> bookList = Files.readAllLines(Path.of(RESOURCE_URL + BOOK_FILE_NAME))
                .stream().map(row -> {
                    String[] dataBook = row.split("\\s+");

                    String tittle = Arrays.stream(dataBook)
                            .skip(5).collect(Collectors.joining(" "));

                    return Book.builder()
                            .author(this.authorService.getRandomAuthor())
                            .categories(this.categoryService.getRandomCategories())
                            .title(tittle)
                            .editionType(EditionType.values()[Integer.parseInt(dataBook[0])])
                            .ageRestriction(AgeRestriction.values()[Integer.parseInt(dataBook[4])])
                            .price(new BigDecimal(dataBook[3]))
                            .copies(Integer.parseInt(dataBook[2]))
                            .releaseDate(LocalDate.parse(dataBook[1], DateTimeFormatter.ofPattern("d/M/yyyy")))
                            .build();
                }).toList();

        this.bookService.seedBooks(bookList);

    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryService.isDataSeeded()) return;

        this.categoryService.seedCategories(Files.readAllLines(Path.of(RESOURCE_URL + CATEGORY_FILE_NAME))
                .stream().filter(s -> !s.isBlank())
                .map(Category::new)
                .toList());

    }
}
