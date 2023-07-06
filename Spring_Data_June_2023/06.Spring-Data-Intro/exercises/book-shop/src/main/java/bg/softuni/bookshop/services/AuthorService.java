package bg.softuni.bookshop.services;

import bg.softuni.bookshop.domain.entities.Author;

import java.time.LocalDate;
import java.util.List;

public interface AuthorService {
    boolean isDataSeeded();

    void seedAuthors(List<Author> authors);

    Author getRandomAuthor();

    List<Author> getALlAuthorWhitBooksBeforeGivenYear(LocalDate date);

    List<Author> getALlAuthorOrderByBookCountDesc();
}
