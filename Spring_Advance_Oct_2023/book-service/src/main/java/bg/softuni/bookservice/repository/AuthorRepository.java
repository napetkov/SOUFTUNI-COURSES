package bg.softuni.bookservice.repository;

import bg.softuni.bookservice.model.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {
    Optional<AuthorEntity> findByName(String name);
}
