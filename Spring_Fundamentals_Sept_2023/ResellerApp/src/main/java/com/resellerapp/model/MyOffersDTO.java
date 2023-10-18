package com.resellerapp.model;

import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.enums.ConditionName;

public class MyOffersDTO extends BoughtOffersDTO{

    private ConditionName condition;

    public MyOffersDTO() {
    }

    public MyOffersDTO(Offer offer) {
        super(offer);
        condition = offer.getCondition().getName();
    }


    public ConditionName getCondition() {
        return condition;
    }

    public MyOffersDTO setCondition(ConditionName condition) {
        this.condition = condition;
        return this;
    }

}
