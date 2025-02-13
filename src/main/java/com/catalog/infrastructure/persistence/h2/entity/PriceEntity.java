package com.catalog.infrastructure.persistence.h2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.GeneratorStrategy;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRICES")
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer priceId;
    private Integer brandId;
    private Integer productId;
    private Short rate;
    private Short priority;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal amount;
    private String currency;
}
