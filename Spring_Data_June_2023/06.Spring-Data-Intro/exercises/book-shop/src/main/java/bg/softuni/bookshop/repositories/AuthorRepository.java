package bg.softuni.bookshop.repositories;

import bg.softuni.bookshop.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//creating the repository interface will create table in database regrading the given Entity
@Repository
public interface AuthorRepository extends JpaRepository <Author, Long> {
    @Query("Select a from Author a order by size(a.books) ")
    Optional<List<Author>> findAllByBooksCountDesc();

}

