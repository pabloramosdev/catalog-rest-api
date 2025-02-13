package com.catalog.application;

import com.catalog.domain.Price;
import com.catalog.domain.exception.ProductNotFoundException;
import com.catalog.domain.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;

@Service
public class SearchBestPriceAtDate {

    private final PriceRepository priceRepository;

    public SearchBestPriceAtDate(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price execute(Integer brandId, Integer productId, LocalDateTime applicationDate) {
        return priceRepository.findPriceByBrandAndProductIdAndDate(brandId, productId, applicationDate)
                .stream()
                .max(Comparator.comparing(Price::getPriority))
                .orElseThrow(() -> new ProductNotFoundException(brandId, productId, applicationDate));
    }

}
