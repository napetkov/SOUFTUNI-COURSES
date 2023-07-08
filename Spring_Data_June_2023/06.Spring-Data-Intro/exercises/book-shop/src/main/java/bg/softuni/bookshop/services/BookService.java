package bg.softuni.bookshop.services;

import bg.softuni.bookshop.domain.entities.Book;
import bg.softuni.bookshop.domain.enums.AgeRestriction;
import bg.softuni.bookshop.domain.enums.EditionType;

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
}
