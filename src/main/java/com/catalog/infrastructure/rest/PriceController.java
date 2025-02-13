package com.catalog.infrastructure.rest;

import com.catalog.application.SearchBestPriceAtDate;
import com.catalog.domain.Price;
import com.catalog.infrastructure.rest.model.PriceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static com.catalog.infrastructure.rest.mapper.PriceResponseMapper.toPriceResponse;

@RestController
public class PriceController {

    private final SearchBestPriceAtDate searchBestPriceAtDate;

    public PriceController(SearchBestPriceAtDate searchBestPriceAtDate) {
        this.searchBestPriceAtDate = searchBestPriceAtDate;
    }

    @GetMapping("/prices")
    public ResponseEntity<PriceResponse> getPrices(@RequestParam Integer brandId,
                                                     @RequestParam Integer productId,
                                                     @RequestParam LocalDateTime applicationDate) {
        Price price = searchBestPriceAtDate.execute(brandId, productId, applicationDate);
        return ResponseEntity.ok(toPriceResponse(price));
    }

}
