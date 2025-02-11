package com.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Brand {
    ZARA(1);

    private final Integer brandId;
}
