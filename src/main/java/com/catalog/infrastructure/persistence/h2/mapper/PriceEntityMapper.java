package com.catalog.infrastructure.persistence.h2.mapper;

import com.catalog.domain.Price;
import com.catalog.infrastructure.persistence.h2.entity.PriceEntity;

public class PriceEntityMapper {

    public static Price priceEntityToPrice(PriceEntity priceEntity) {
        return Price.builder()
                .brandId(priceEntity.getPriceEntityId().getBrandId())
                .productId(priceEntity.getPriceEntityId().getProductId())
                .startDate(priceEntity.getPriceEntityId().getStartDate())
                .endDate(priceEntity.getPriceEntityId().getEndDate())
                .rateType(priceEntity.getRate())
                .priority(priceEntity.getPriority())
                .amount(priceEntity.getAmount())
                .currency(priceEntity.getCurrency())
                .build();
    }

}
