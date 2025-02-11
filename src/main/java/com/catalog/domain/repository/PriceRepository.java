package com.catalog.domain.repository;

import com.catalog.domain.Brand;
import com.catalog.domain.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {
    List<Price> findPriceByBrandAndProductIdAndDate(Brand brand, Integer productId, LocalDateTime dateTime);
}
