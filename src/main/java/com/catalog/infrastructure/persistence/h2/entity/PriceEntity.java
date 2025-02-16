package com.catalog.infrastructure.persistence.h2.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "PRICES")
public class PriceEntity {
    @EmbeddedId
    private PriceEntityId priceEntityId;
    private Short rate;
    private Short priority;
    private BigDecimal amount;
    private String currency;

    public PriceEntity() {
    }

    public PriceEntity(PriceEntityId priceEntityId, Short priority, BigDecimal amount, String currency, Short rate) {
        this.priceEntityId = priceEntityId;
        this.priority = priority;
        this.amount = amount;
        this.currency = currency;
        this.rate = rate;
    }

    public PriceEntityId getPriceEntityId() {
        return priceEntityId;
    }

    public void setPriceEntityId(PriceEntityId priceEntityId) {
        this.priceEntityId = priceEntityId;
    }

    public Short getRate() {
        return rate;
    }

    public void setRate(Short rate) {
        this.rate = rate;
    }

    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
