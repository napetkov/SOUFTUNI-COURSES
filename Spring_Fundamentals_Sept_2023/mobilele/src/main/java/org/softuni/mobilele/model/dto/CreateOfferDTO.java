package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.*;
import org.softuni.mobilele.model.enums.EngineEnum;
import org.softuni.mobilele.model.enums.TransmissionEnum;

public final class CreateOfferDTO {
    private @NotEmpty @Size(min = 2, max = 512) String description;
    private @Positive @NotNull Long modelId;
    private @NotNull EngineEnum engine;
    private @NotNull TransmissionEnum transmission;
    private @NotEmpty String imageUrl;
    private @Positive @NotNull Long mileage;
    private @Positive @NotNull Integer price;
    private  @NotNull @Min(1930) Integer year;

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

    public Integer getPrice() {
        return price;
    }

    public CreateOfferDTO setPrice(Integer price) {
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
