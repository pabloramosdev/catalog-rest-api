package com.catalog.infrastructure.persistence.h2;

import com.catalog.domain.Price;
import com.catalog.domain.repository.PriceRepository;
import com.catalog.infrastructure.persistence.h2.mapper.PriceEntityMapper;
import com.catalog.infrastructure.persistence.h2.repository.PriceEntityRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PriceRepositoryAdapter implements PriceRepository {

    private final PriceEntityRepository priceEntityRepository;

    public PriceRepositoryAdapter(PriceEntityRepository priceEntityRepository) {
        this.priceEntityRepository = priceEntityRepository;
    }

    @Override
    public List<Price> findPriceByBrandAndProductIdAndDate(Integer brandId, Integer productId, LocalDateTime applicationDate) {
        return priceEntityRepository.findByBrandIdAndProductIdAndBetweenDates(brandId, productId, applicationDate)
                .stream()
                .map(PriceEntityMapper::priceEntityToPrice)
                .toList();
    }

}
