package org.softuni.mobilele.model.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.JdbcTypeCode;
import org.softuni.mobilele.model.entity.ModelEntity;
import org.softuni.mobilele.model.enums.EngineEnum;
import org.softuni.mobilele.model.enums.TransmissionEnum;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;

public record CreateOfferDTO(
        String description,
        Long modelId,
        EngineEnum engine,
        TransmissionEnum transmission,
        String imageUrl,
        Long mileage,
        BigDecimal price,
        Integer year
) {}
