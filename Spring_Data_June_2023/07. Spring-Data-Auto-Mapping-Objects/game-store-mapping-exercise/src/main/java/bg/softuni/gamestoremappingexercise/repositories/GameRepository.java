package bg.softuni.gamestoremappingexercise.repositories;

import bg.softuni.gamestoremappingexercise.domain.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {


    Optional<Game> findFirstById(Long id);

    Optional<Game> findFirstByTitle(String gameTitle);

    @Override
    List<Game> findAll();

//    @Query("select g from Game g where User.id = :id")
//    Set<Game> findAllByUserId(Long id);
}
