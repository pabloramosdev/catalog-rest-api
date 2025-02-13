package com.catalog.infrastructure.rest.mapper;

import com.catalog.domain.Price;
import com.catalog.infrastructure.rest.model.PriceResponse;

public class PriceResponseMapper {

    public static PriceResponse toPriceResponse(Price price) {
        return PriceResponse.builder()
                .brandId(price.getBrandId())
                .productId(price.getProductId())
                .rateApplied(price.getRateType())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .price(price.getAmount())
                .currency(price.getCurrency())
                .build();
    }

}
