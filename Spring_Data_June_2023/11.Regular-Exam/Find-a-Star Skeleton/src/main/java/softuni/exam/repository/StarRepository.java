package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
    List<Star> findAllByStarTypeAndNotObservingNative(StarType type);

    List<Star> findAllByStarTypeOrderByLightYears(StarType type);

    @Query(value = "select s from Star s where Star.starType = :type and Star.id not in (select a.star.id from Astronomer a) order by s.lightYears asc")
    List<Star> findAllByStarTypeOrderByLightYearsAndNotObserving(StarType type);


}
