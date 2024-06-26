package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entitnies.Town;

import java.util.Optional;

@Repository
public interface TownRepository  extends JpaRepository<Town,Long> {
    Optional<Town> findFirstByName(String name);
}
