package bg.softuni.bookshop.repositories;

import bg.softuni.bookshop.domain.entities.Book;
import bg.softuni.bookshop.domain.enums.AgeRestriction;
import bg.softuni.bookshop.domain.enums.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//creating the repository interface will create table in database regrading the given Entity
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<List<Book>> findAllByReleaseDateAfter(LocalDate date);
    Optional<List<Book>> findAllByReleaseDateBefore(LocalDate date);

    Optional<List<Book>>findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesIsLessThan(EditionType editionType,long copies);
}
