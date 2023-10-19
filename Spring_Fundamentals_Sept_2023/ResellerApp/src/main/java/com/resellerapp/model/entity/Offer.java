package com.resellerapp.model.entity;

import com.resellerapp.model.MyOffersDTO;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{
    @NotNull
    @Length(min = 2, max = 50)
    private String description;

    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    @ManyToOne
    private Condition condition;
    @ManyToOne
    @NotNull
    private User createdBy;
    @ManyToOne
    private User boughtBy;

    public Offer(MyOffersDTO myOffersDTO, Condition condition, User createdBy) {
        this.description = myOffersDTO.getDescription();
        this.price = myOffersDTO.getPrice();
        this.condition = condition;
        this.createdBy = createdBy;
    }

    public Offer() {
    }

    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Offer setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Condition getCondition() {
        return condition;
    }

    public Offer setCondition(Condition condition) {
        this.condition = condition;
        return this;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Offer setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public User getBoughtBy() {
        return boughtBy;
    }

    public Offer setBoughtBy(User boughtBy) {
        this.boughtBy = boughtBy;
        return this;
    }
}
