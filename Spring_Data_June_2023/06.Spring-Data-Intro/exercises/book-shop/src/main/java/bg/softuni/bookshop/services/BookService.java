package bg.softuni.bookshop.services;

import bg.softuni.bookshop.domain.entities.Book;
import bg.softuni.bookshop.domain.enums.AgeRestriction;
import bg.softuni.bookshop.domain.enums.EditionType;
import bg.softuni.bookshop.domain.model.BookPrintInformation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    boolean isDataSeeded();

    void seedBooks(List<Book> books);
    List<Book> getAllBooksAfterGivenYear(LocalDate date);

    List<Book> getAllBooksBeforeGivenYear(LocalDate date);

    List<Book> getAllBooksFromAuthorOrderedByReleaseDateAndTitle(String firstName, String lastName);

    List<Book> getAllBooksByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> getAllBooksWithGoldenEditionWithLessThanCopies(EditionType editionType,long numbersOfCopies);

    List<Book> getAllBooksWithPriceLessThanAndGreaterThan(BigDecimal firstPrice, BigDecimal secondPrice);

    List<Book> getAllBooksIsNotReleasedInYear(int year);


    List<Book> getAllBooksTitleContainsString(String substringOfTitle);

    List<Book> getAllBooksAuthorStartWith(String substring);

    int getCountOfBooksLengthTitleLessThan(int lengthOfTitle);

    Integer getCountOfBooksWithAuthorDesc(String firstName, String lastName);

    List<BookPrintInformation> getBookWithTitle(String bookTitle);

    Integer updateAllByCopiesAndReleaseDateAfter(Integer copiesToIncreaseWith, LocalDate dateReleasedAfter);

    Integer deleteBooksWithCopiesLessThan(int inputNumberOfCopies);

    int getCountOfBooksWithAuthorFullName(String authorFullName);
}
