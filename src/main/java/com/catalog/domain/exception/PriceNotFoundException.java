package com.catalog.domain.exception;

import java.time.LocalDateTime;

public class PriceNotFoundException extends RuntimeException {
    private Integer brandId;
    private Integer productId;
    private LocalDateTime applicationDate;

    public PriceNotFoundException(Integer brandId, Integer productId, LocalDateTime applicationDate) {
        this.brandId = brandId;
        this.productId = productId;
        this.applicationDate = applicationDate;
    }

    public PriceNotFoundException() {
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public Integer getProductId() {
        return productId;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

}
