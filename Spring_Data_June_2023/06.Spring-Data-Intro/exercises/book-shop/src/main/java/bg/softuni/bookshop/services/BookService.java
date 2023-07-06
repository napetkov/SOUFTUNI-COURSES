package bg.softuni.bookshop.services;

import bg.softuni.bookshop.domain.entities.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookService {
    boolean isDataSeeded();

    void seedBooks(List<Book> books);
    List<Book> getAllBooksAfterGivenYear(LocalDate date);

    List<Book> getAllBooksBeforeGivenYear(LocalDate date);

}
