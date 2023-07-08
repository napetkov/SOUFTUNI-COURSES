package bg.softuni.bookshop.services;

import bg.softuni.bookshop.domain.entities.Book;
import bg.softuni.bookshop.domain.enums.AgeRestriction;
import bg.softuni.bookshop.domain.enums.EditionType;
import bg.softuni.bookshop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean isDataSeeded() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public void seedBooks(List<Book> books) {
        bookRepository.saveAllAndFlush(books);
    }

    @Override
    public List<Book> getAllBooksAfterGivenYear(LocalDate date) {
        List<Book> allBooksAfterGivenYear = this.bookRepository.findAllByReleaseDateAfter(date).get();

        System.out.println(allBooksAfterGivenYear.stream().map(Book::getTitle).collect(Collectors.joining("\n")));

        return allBooksAfterGivenYear;
    }

    @Override
    public List<Book> getAllBooksBeforeGivenYear(LocalDate date) {

        return this.bookRepository
                .findAllByReleaseDateBefore(date)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> getAllBooksFromAuthorOrderedByReleaseDateAndTitle(String firstName, String lastName) {
        return bookRepository.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> getAllBooksByAgeRestriction(AgeRestriction ageRestriction) {
        return bookRepository.findAllByAgeRestriction(ageRestriction);
    }

    @Override
    public List<Book> getAllBooksWithGoldenEditionWithLessThanCopies(EditionType editionType,long numbersOfCopies) {
        return bookRepository.findAllByEditionTypeAndCopiesIsLessThan(editionType,numbersOfCopies);
    }


}
