package com.catalog.domain.repository;

import com.catalog.domain.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {
    List<Price> findPriceByBrandAndProductIdAndDate(Integer brand, Integer productId, LocalDateTime dateTime);
}
