package bg.softuni.bookshop.services;

import bg.softuni.bookshop.domain.entities.Author;
import bg.softuni.bookshop.domain.entities.Book;
import bg.softuni.bookshop.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;


//by presumption all entities have to have a service that will manipulate the info from teh database
@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    private BookService bookService;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, BookService bookService) {
        this.authorRepository = authorRepository;
        this.bookService = bookService;
    }

    @Override
    public boolean isDataSeeded() {
        return this.authorRepository.count() > 0;
    }

    @Override
    public void seedAuthors(List<Author> authors) {
    authorRepository.saveAllAndFlush(authors);
    }

    @Override
    public Author getRandomAuthor() {
        final long count = this.authorRepository.count();

        if(count != 0){
            long randomId = new Random().nextLong(1L, count) + 1L;
            return this.authorRepository.findById(randomId).orElseThrow(NoSuchElementException::new);
        }

        throw new RuntimeException();
    }

    @Override
    public List<Author> getALlAuthorWhitBooksBeforeGivenYear(LocalDate date) {
        List<Author> authors = bookService.getAllBooksBeforeGivenYear(date)
                .stream().map(Book::getAuthor)
                .toList();

        System.out.println(authors.stream()
                .map(Author::getAuthorFullName)
                .collect(Collectors.joining("\n")));


        return authors;
    }

    @Override
    public List<Author> getALlAuthorOrderByBookCountDesc() {
        List<Author> authors = authorRepository.findAllByBooksCountDesc()
                        .orElseThrow(NoSuchElementException::new);

        System.out.println(authors
                .stream().map(Author::getAuthorFullNameAndBookCount)
                .collect(Collectors.joining("\n")));


        return authors;
    }

    @Override
    public List<Author> getAllAuthorsEndsWith(String authorEndsWith) {

        return authorRepository.findAllByFirstNameEndsWith(authorEndsWith);
    }
}
