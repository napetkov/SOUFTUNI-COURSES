package com.resellerapp.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{
    @Column(nullable = false)
    @Length(min = 2,max = 50)
    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    @ManyToOne
    private Condition condition;
    @ManyToOne
    private User createBy;
    @ManyToOne
    private User boughtBy;

    public User getCreateBy() {
        return createBy;
    }

    public Offer setCreateBy(User createBy) {
        this.createBy = createBy;
        return this;
    }

    public User getBoughtBy() {
        return boughtBy;
    }

    public Offer setBoughtBy(User boughtBy) {
        this.boughtBy = boughtBy;
        return this;
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
}
