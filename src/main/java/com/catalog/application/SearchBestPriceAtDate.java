package com.catalog.application;

import com.catalog.domain.Brand;
import com.catalog.domain.Price;
import com.catalog.domain.exception.ProductNotFoundException;
import com.catalog.domain.repository.PriceRepository;

import java.time.LocalDateTime;
import java.util.Comparator;

public class SearchBestPriceAtDate {

    private final PriceRepository priceRepository;

    public SearchBestPriceAtDate(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price findBestPriceAtDate(Brand brand, Integer productId, LocalDateTime applicationDate) {
        return priceRepository.findPriceByBrandAndProductIdAndDate(brand, productId, applicationDate)
                .stream()
                .max(Comparator.comparing(Price::getPriority))
                .orElseThrow(() -> new ProductNotFoundException(brand.getBrandId(), productId, applicationDate));
    }

}
