package com.catalog.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ProductNotFoundException extends RuntimeException {
    private final Integer brandId;
    private final Integer productId;
    private final LocalDateTime applicationDate;
}
