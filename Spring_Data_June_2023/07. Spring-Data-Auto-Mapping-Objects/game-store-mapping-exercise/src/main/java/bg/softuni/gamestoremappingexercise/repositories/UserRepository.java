package bg.softuni.gamestoremappingexercise.repositories;

import bg.softuni.gamestoremappingexercise.domain.entities.Game;
import bg.softuni.gamestoremappingexercise.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findFirstByEmail(String email);
}
