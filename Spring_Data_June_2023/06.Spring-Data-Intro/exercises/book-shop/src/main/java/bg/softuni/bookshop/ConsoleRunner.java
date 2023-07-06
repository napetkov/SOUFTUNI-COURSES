package bg.softuni.bookshop;

import bg.softuni.bookshop.services.AuthorService;
import bg.softuni.bookshop.services.BookService;
import bg.softuni.bookshop.services.CategoryService;
import bg.softuni.bookshop.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


//after suc compilation of our program run method will be run.
@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final BookService bookService;

    private final AuthorService authorService;

    private final CategoryService categoryService;


    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService, CategoryService categoryService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedAllData();
//        this.bookService.getAllBooksAfterGivenYear(LocalDate.of(2000,1,1));

//        this.authorService.getALlAuthorWhitBooksBeforeGivenYear(LocalDate.of(1990,1,1));

            authorService.getALlAuthorOrderByBookCountDesc();
    }
}
