package com.catalog.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Price {
    private Brand brand;
    private Integer productId;
    private Short rateType;
    private Short priority;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal amount;
    private Currency currency;
}
