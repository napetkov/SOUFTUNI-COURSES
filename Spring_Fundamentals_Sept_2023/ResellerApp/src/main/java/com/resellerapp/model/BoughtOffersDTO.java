package com.resellerapp.model;

import com.resellerapp.model.entity.Offer;

import java.math.BigDecimal;

public class BoughtOffersDTO {

    private String description;
    private BigDecimal price;

    public BoughtOffersDTO() {
    }

    public BoughtOffersDTO(Offer offer) {
        description = offer.getDescription();
        price = offer.getPrice();
    }

    public String getDescription() {
        return description;
    }

    public BoughtOffersDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BoughtOffersDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
