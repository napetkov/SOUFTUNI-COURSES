package softuni.exam.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Offer;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {

    List<Offer> findAllByApartmentApartmentTypeOrderByApartmentAreaDescPriceAsc
            (ApartmentType apartmentType);

}
