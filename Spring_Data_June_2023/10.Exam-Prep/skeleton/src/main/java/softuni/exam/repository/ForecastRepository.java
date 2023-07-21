package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.DayOfWeek;
import softuni.exam.models.entity.Forecast;
import softuni.exam.service.ForecastService;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast,Long> {

    Optional<Forecast> findFirstByCityIdAndDayOfWeek(Long cityId, DayOfWeek dayOfWeek);

    List<Forecast> findAllByDayOfWeekAndCityPopulationLessThan(DayOfWeek dayOfWeek,Integer population);
}
