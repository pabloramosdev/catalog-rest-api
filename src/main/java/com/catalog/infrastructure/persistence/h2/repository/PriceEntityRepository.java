package com.catalog.infrastructure.persistence.h2.repository;

import com.catalog.infrastructure.persistence.h2.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceEntityRepository extends JpaRepository<PriceEntity, Long> {

    @Query("""
            select p from PriceEntity p where p.priceEntityId.brandId = :brand_id and p.priceEntityId.productId = :product_id and \
            p.priceEntityId.startDate <= :application_date and p.priceEntityId.endDate >= :application_date""")
    List<PriceEntity> findByBrandIdAndProductIdAndBetweenDates(@Param("brand_id") Integer brandId,
                                                               @Param("product_id") Integer productId,
                                                               @Param("application_date") LocalDateTime applicationDate);

}
