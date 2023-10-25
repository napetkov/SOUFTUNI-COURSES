package bg.softuni.bookservice.repository;

import bg.softuni.bookservice.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
