package bg.softuni.bookshop.repositories;

import bg.softuni.bookshop.domain.entities.Book;
import bg.softuni.bookshop.domain.enums.AgeRestriction;
import bg.softuni.bookshop.domain.enums.EditionType;
import bg.softuni.bookshop.domain.model.BookPrintInformation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//creating the repository interface will create table in database regrading the given Entity
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<List<Book>> findAllByReleaseDateAfter(LocalDate date);

    Optional<List<Book>> findAllByReleaseDateBefore(LocalDate date);

    Optional<List<Book>> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesIsLessThan(EditionType editionType, long copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal firstPrice, BigDecimal secondPrice);

    @Query("select b from Book b where year(b.releaseDate) != :year")
    List<Book> findAllByReleaseDate(int year);

    List<Book> findAllByTitleContains(String substring);

    List<Book> findAllByAuthorLastNameStartingWith(String substring);

    @Query("select count(b.title) from Book b where length(b.title) > :lengthOfTitle")
    Integer countBookByTitleLengthLessThan(int lengthOfTitle);

    Integer countBookByAuthorFirstNameAndAuthorLastNameOrderByCopiesDesc(String firstName, String lastName);

    @Query
    List <BookPrintInformation> findByTitle(String title);

    @Modifying
    @Transactional
    @Query("Update Book b set b.copies = b.copies + :copiesToIncrease " +
            "where b.releaseDate > :date")
    int updatePriceWithReleaseDateAfter(Integer copiesToIncrease, LocalDate date);

    @Modifying
    @Transactional
    int deleteBooksByCopiesLessThan(int numberOfCopies);

    @Procedure(value = "usp_select_books_by_author_full_name")
    int getBookByAuthorFirstNameAndAuthorLastName(String fullName);
}
