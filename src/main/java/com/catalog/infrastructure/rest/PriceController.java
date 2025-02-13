package com.catalog.infrastructure.rest;

import com.catalog.application.SearchBestPriceAtDate;
import com.catalog.domain.Price;
import com.catalog.infrastructure.rest.model.PriceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
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

    @Operation(summary = "Gets the price of a product for a brand in a date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "",
                    content = @Content(schema = @Schema(implementation = PriceResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid parameter values"),
            @ApiResponse(responseCode = "404", description = "Price not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error") })
    @GetMapping(value = "/prices", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceResponse> getPrices(@RequestParam Integer brandId,
                                                     @RequestParam Integer productId,
                                                     @RequestParam LocalDateTime applicationDate) {
        Price price = searchBestPriceAtDate.execute(brandId, productId, applicationDate);
        return ResponseEntity.ok(toPriceResponse(price));
    }

}
