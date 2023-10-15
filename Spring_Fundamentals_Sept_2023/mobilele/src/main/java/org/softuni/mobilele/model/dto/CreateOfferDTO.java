package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.*;
import org.softuni.mobilele.model.enums.EngineEnum;
import org.softuni.mobilele.model.enums.TransmissionEnum;
import org.softuni.mobilele.model.validation.YearNotInTheFuture;

import java.math.BigDecimal;

public final class CreateOfferDTO {
    @NotEmpty
    @Size(min = 2, max = 512)
    private String description;
    @Positive
    @NotNull
    private Long modelId;
    @NotNull
    private EngineEnum engine;
    @NotNull
    private TransmissionEnum transmission;
    @NotEmpty
    private String imageUrl;
    @Positive
    @NotNull
    private Long mileage;
    @Positive
    private @NotNull BigDecimal price;
    @YearNotInTheFuture(message = "The year should not be in the future!")
    @NotNull(message = "Year must be provided!")
    @Min(1930)
    private Integer year;

    public String getDescription() {
        return description;
    }

    public CreateOfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getModelId() {
        return modelId;
    }

    public CreateOfferDTO setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public CreateOfferDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public CreateOfferDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CreateOfferDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Long getMileage() {
        return mileage;
    }

    public CreateOfferDTO setMileage(Long mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CreateOfferDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public CreateOfferDTO setYear(Integer year) {
        this.year = year;
        return this;
    }
}
