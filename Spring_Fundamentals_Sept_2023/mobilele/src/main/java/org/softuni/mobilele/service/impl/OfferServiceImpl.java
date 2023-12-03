package org.softuni.mobilele.service.impl;

import jakarta.transaction.Transactional;
import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.model.dto.OfferDetailDTO;
import org.softuni.mobilele.model.dto.OfferSummaryDTO;
import org.softuni.mobilele.model.entity.ModelEntity;
import org.softuni.mobilele.model.entity.OfferEntity;
import org.softuni.mobilele.model.enums.EngineEnum;
import org.softuni.mobilele.model.enums.TransmissionEnum;
import org.softuni.mobilele.repository.ModelRepository;
import org.softuni.mobilele.repository.OfferRepository;
import org.softuni.mobilele.service.OfferService;
import org.softuni.mobilele.service.exception.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {

        OfferEntity newOffer = map(createOfferDTO);

        ModelEntity modelEntity = modelRepository.findById(createOfferDTO.getModelId()).
                orElseThrow(() -> new IllegalArgumentException("Model with id" + createOfferDTO.getModelId() + "not found"));

        newOffer.setModel(modelEntity);

        newOffer = offerRepository.save(newOffer);

        return newOffer.getUuid();
    }

    @Override
    public Page<OfferSummaryDTO> getAllOffers(Pageable pageable) {
        return offerRepository.findAll(pageable)
                .map(OfferServiceImpl::mapAsSummery);
    }

    @Override
    public Optional<OfferDetailDTO> getOfferDetail(UUID offerUUID) {
        return offerRepository.findByUuid(offerUUID)
                .map(OfferServiceImpl::mapAsDetails);
    }

    @Override
    @Transactional
    public void deleteOfferByUuid(UUID offerUUID) {
        offerRepository.deleteByUuid(offerUUID);
    }

    private static OfferDetailDTO mapAsDetails(OfferEntity offerEntity) {
        //TODO: reuse
        return new OfferDetailDTO(
                offerEntity.getUuid().toString(),
                offerEntity.getModel().getBrand().getName(),
                offerEntity.getModel().getName(),
                offerEntity.getYear(),
                offerEntity.getMileage(),
                offerEntity.getPrice(),
                offerEntity.getEngine(),
                offerEntity.getTransmission(),
                offerEntity.getImageUrl()
        );
    }
    private static OfferSummaryDTO mapAsSummery(OfferEntity offerEntity) {
        return new OfferSummaryDTO(
                offerEntity.getUuid().toString(),
                offerEntity.getModel().getBrand().getName(),
                offerEntity.getModel().getName(),
                offerEntity.getYear(),
                offerEntity.getMileage(),
                offerEntity.getPrice(),
                offerEntity.getEngine(),
                offerEntity.getTransmission(),
                offerEntity.getImageUrl()
        );
    }

    private static OfferEntity map(CreateOfferDTO createOfferDTO) {
        return new OfferEntity()
                .setUuid(UUID.randomUUID())
                .setDescription(createOfferDTO.getDescription())
                .setEngine(createOfferDTO.getEngine())
                .setImageUrl(createOfferDTO.getImageUrl())
                .setMileage(createOfferDTO.getMileage())
                .setPrice(createOfferDTO.getPrice())
                .setTransmission(createOfferDTO.getTransmission())
                .setYear(createOfferDTO.getYear());

    }
}
