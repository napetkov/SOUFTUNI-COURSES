package bg.softuni.bookshop;

import bg.softuni.bookshop.domain.enums.AgeRestriction;
import bg.softuni.bookshop.domain.enums.EditionType;
import bg.softuni.bookshop.domain.model.BookPrintInformation;
import bg.softuni.bookshop.services.AuthorService;
import bg.softuni.bookshop.services.BookService;
import bg.softuni.bookshop.services.CategoryService;
import bg.softuni.bookshop.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
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


//        TODO: Refactoring
//        while + switch case for calling all print methods for different tasks

        System.out.println("Please enter the number of Task from 1 to 14 or END to exit the application:");

        String input = scanner.nextLine();

        while (!"END".equals(input)) {

            int numberOfTask = Integer.parseInt(input);

            switch (numberOfTask) {
                case 1 -> printAllBooksByAgeRestriction();

                case 2 -> printBooksTitleByEditionType();

                case 3 -> printAllBooksTitelThatThePircesWillBeTheBorder();

                case 4 -> printAllBooksTitleThatNotBeReleasedOnYear();

                case 5 -> printAllBoosTitlesEditionTypeAndPriceForReleaseDateBefore();

                case 6 -> printFullNamesOfAuthorsThatFirstNameEdnsWith();

                case 7 -> printAllBooksThatTitleContains();

                case 8 -> printAllBooksTitelWichAuthoLastNameEndsWith();

                case 9 -> printTheCountOfBooksWhoesLendthOfTitleIsLonger();

                case 10 -> printTotalNumberOfBooksCopiesOfAuthor();

                case 11 -> printOnlyReturnedBooksInformation();

                case 12 -> printIncreasedNumbersOfcopies();

                case 13 -> printAllRemovedBooksWithCopiesLessThan();

                case 14 -> printAllWrittenBooksOfAuthor();

                default -> System.out.println("Please enter correct number of Task from 1 to 14");
            }

            System.out.println("Please enter the number of Task from 1 to 14 or END to exit the application:");

            input = scanner.nextLine();
        }


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



    }

    private void printAllWrittenBooksOfAuthor() {
        System.out.println("Please enter the full name of Author :");
        String authorFullName = scanner.nextLine();

        int countOfBooksByAuthor = bookService.getCountOfBooksWithAuthorFullName(authorFullName);

        System.out.printf("%s has written %d books\n", authorFullName, countOfBooksByAuthor);
    }

    private void printAllRemovedBooksWithCopiesLessThan() {
        System.out.println("Please enter number of copies, that books will be removed:");
        int inputNumberOfCopies = Integer.parseInt(scanner.nextLine());

        Integer removedBooks = bookService.deleteBooksWithCopiesLessThan(inputNumberOfCopies);

        System.out.println("Removed books with copies less than " + inputNumberOfCopies + " - " + removedBooks + ".");
    }

    private void printIncreasedNumbersOfcopies() {
        System.out.println("Please enter release date of the Books:");
        String releaseDate = scanner.nextLine();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
        LocalDate dateReleasedAfter = LocalDate.parse(releaseDate, dateTimeFormatter);

        System.out.println("Please enter the number of copies that will be increased:");
        int copiesToIncreaseWith = Integer.parseInt(scanner.nextLine());

        Integer numbersOfBooksWithIncreasedCopies =
                bookService.updateAllByCopiesAndReleaseDateAfter(copiesToIncreaseWith, dateReleasedAfter);

        System.out.println(copiesToIncreaseWith * numbersOfBooksWithIncreasedCopies);
    }

    private void printOnlyReturnedBooksInformation() {
        System.out.println("Please enter the Book's Title:");
        String bookTitle = scanner.nextLine();

        List<BookPrintInformation> bookWithTitle = bookService.getBookWithTitle(bookTitle);

        bookWithTitle.forEach(System.out::println);
    }

    private void printTotalNumberOfBooksCopiesOfAuthor() {
        System.out.println("Please enter the full name of Author:");
        String[] authorFullName = scanner.nextLine().split(" ");

        String firstName = authorFullName[0];
        String lastName = authorFullName[1];
        Integer countOfBooksWithAuthorDesc = bookService.getCountOfBooksWithAuthorDesc(firstName, lastName);

        System.out.printf("%s %s - %d\n", firstName, lastName, countOfBooksWithAuthorDesc);
    }

    private void printTheCountOfBooksWhoesLendthOfTitleIsLonger() {
        System.out.println("Please enter length of title, whose is longer than a given:");

        System.out.println(bookService.getCountOfBooksLengthTitleLessThan(Integer.parseInt(scanner.nextLine())));
    }

    private void printAllBooksTitelWichAuthoLastNameEndsWith() {
        System.out.println("Please enter the char sequence that Author's last name start with:");
        String substring = scanner.nextLine();

        bookService.getAllBooksAuthorStartWith(substring)
                .forEach(book -> System.out.println(book.getTitle()));
    }

    private void printAllBooksThatTitleContains() {
        System.out.println("Please enter char sequence that will contains in the Book's title:");
        String substringOfTitle = scanner.nextLine();

        bookService.getAllBooksTitleContainsString(substringOfTitle)
                .forEach(book -> System.out.println(book.getTitle()));
    }

    private void printFullNamesOfAuthorsThatFirstNameEdnsWith() {
        System.out.println("Please enter char sequence that Author's first name ends with:");
        String authorEndsWith = scanner.nextLine();

        authorService.getAllAuthorsEndsWith(authorEndsWith)
                .forEach(author -> System.out.println(author.getAuthorFullName()));
    }

    private void printAllBoosTitlesEditionTypeAndPriceForReleaseDateBefore() {
        System.out.println("Please enter the date in format dd-MM-yyyy that will be upper border of release date:");
        String year = scanner.nextLine();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateBefore = LocalDate.parse(year, dateTimeFormatter);

        bookService.getAllBooksBeforeGivenYear(dateBefore)
                .forEach(book -> System.out.println(book.getBooksTitleEditionTypeAndPriceFormat()));
    }

    private void printAllBooksTitleThatNotBeReleasedOnYear() {
        System.out.println("Please enter Year that the books was not released:");

        bookService.getAllBooksIsNotReleasedInYear(Integer.parseInt(scanner.nextLine()))
                .forEach(book -> System.out.println(book.getTitle()));
    }

    private void printAllBooksTitelThatThePircesWillBeTheBorder() {
        System.out.println("Please enter PRICE that requested to be lower:");
        int priceLow = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter PRICE that requested to be higher:");
        int priceHigh = Integer.parseInt(scanner.nextLine());

        bookService.getAllBooksWithPriceLessThanAndGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .forEach(book -> System.out.printf("%s - $%s\n", book.getTitle(), book.getPrice()));
    }

    private void printBooksTitleByEditionType() {
        System.out.println("Please enter Edition Type: ");
        String editionType = scanner.nextLine().toUpperCase();

        System.out.println("Please enter less than copies: ");
        long numbersOfCopies = Long.parseLong(scanner.nextLine());

        bookService.getAllBooksWithGoldenEditionWithLessThanCopies(EditionType.valueOf(editionType), numbersOfCopies)
                .forEach(book -> System.out.println(book.getTitle()));
    }

    private void printAllBooksByAgeRestriction() {
        System.out.println("Please enter the age restriction for searching books:");
        String ageRestriction = scanner.nextLine().toUpperCase();

        bookService.getAllBooksByAgeRestriction(AgeRestriction.valueOf(ageRestriction))
                .forEach(book -> System.out.println(book.getTitle()));
    }
}
