package softuni.exam.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.StarType;

import java.util.List;
import java.util.Optional;

@Repository
public interface StarRepository extends JpaRepository<Star,Long> {

    Optional<Star> findFirstByName(String name);

    @Query(value = "select * from star.stars as s " +
            "left join star.astronomers a on s.id = a.observing_star_id " +
            "where s.star_type = 'RED_GIANT' and a.id IS NULL " +
            "order by s.light_years asc ",nativeQuery = true)
    List<Star> findAllByStarTypeAndNotObserving(StarType type);

    List<Star> findAllByStarTypeOrderByLightYears(StarType type);
}
