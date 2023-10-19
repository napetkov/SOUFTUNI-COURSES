package com.resellerapp.model;

import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.enums.ConditionName;

import java.util.UUID;

public class MyOffersDTO extends BoughtOffersDTO{

    private ConditionName condition;
    private UUID id;

    public MyOffersDTO() {
    }

    public MyOffersDTO(Offer offer) {
        super(offer);
        id = offer.getId();
        condition = offer.getCondition().getName();
    }


    public ConditionName getCondition() {
        return condition;
    }

    public MyOffersDTO setCondition(ConditionName condition) {
        this.condition = condition;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public MyOffersDTO setId(UUID id) {
        this.id = id;
        return this;
    }
}
