package bg.softuni.bookshop;

import bg.softuni.bookshop.domain.entities.Book;
import bg.softuni.bookshop.domain.enums.AgeRestriction;
import bg.softuni.bookshop.domain.enums.EditionType;
import bg.softuni.bookshop.services.AuthorService;
import bg.softuni.bookshop.services.BookService;
import bg.softuni.bookshop.services.CategoryService;
import bg.softuni.bookshop.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;


//after suc compilation of our program run method will be run.
@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final BookService bookService;

    private final AuthorService authorService;

    private final CategoryService categoryService;

    private final Scanner scanner;


    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService, CategoryService categoryService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedAllData();
//SPRING DATA INTRO - EXERCISES
//  #1
//        this.bookService.getAllBooksAfterGivenYear(LocalDate.of(2000,1,1));
//  #2
//        this.authorService.getALlAuthorWhitBooksBeforeGivenYear(LocalDate.of(1990,1,1));
//  #3
//            authorService.getALlAuthorOrderByBookCountDesc();
//  #4
//        String[] authorFullName = scanner.nextLine().split(" ");

//        List<Book> booksByAuthor = bookService
//        .getAllBooksFromAuthorOrderedByReleaseDateAndTitle(authorFullName[0], authorFullName[1]);
//        booksByAuthor.forEach(book -> System.out.println(book.getBooksTitleReleaseDateCopiesFormat()));



//SPRING ADVANCE QUERYING - EXERCISES
//      #1
//        String ageRestriction = scanner.nextLine().toUpperCase();
//        bookService.getAllBooksByAgeRestriction(AgeRestriction.valueOf(ageRestriction))
//        .forEach(book -> System.out.println(book.getTitle()));
//      #2
        System.out.println("Please enter Edition Type: ");
        String editionType = scanner.nextLine().toUpperCase();
        System.out.println("Please enter less than copies: ");
        long numbersOfCopies = scanner.nextLong();

        bookService.getAllBooksWithGoldenEditionWithLessThanCopies(EditionType.valueOf(editionType),numbersOfCopies)
                .forEach(book -> System.out.println(book.getTitle()));
    }
}
