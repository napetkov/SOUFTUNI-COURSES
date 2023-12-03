package org.softuni.mobilele.repository;

import org.softuni.mobilele.model.dto.OfferDetailDTO;
import org.softuni.mobilele.model.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity,Long> {
    Optional<OfferEntity> findByUuid(UUID offerUUID);

    void deleteByUuid(UUID uuid);
}
