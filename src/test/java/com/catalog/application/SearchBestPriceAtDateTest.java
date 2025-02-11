package com.catalog.application;

import com.catalog.domain.Price;
import com.catalog.domain.exception.ProductNotFoundException;
import com.catalog.domain.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.catalog.domain.Brand.ZARA;
import static com.catalog.domain.Currency.EUR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SearchBestPriceAtDateTest {

    @InjectMocks
    private SearchBestPriceAtDate searchBestPriceAtDate;

    @Mock
    private PriceRepository priceRepository;

    @Test
    void shouldReturnBestPrice_whenSearchExistingProduct() {
        List<Price> listOfPrices = List.of(
                Price.builder()
                        .brand(ZARA)
                        .productId(1)
                        .rateType((short) 1)
                        .priority((short) 1)
                        .startDate(LocalDateTime.now())
                        .endDate(LocalDateTime.now().plusMonths(3))
                        .amount(BigDecimal.valueOf(35.50))
                        .currency(EUR).build()
        );

        when(priceRepository.findPriceByBrandAndProductIdAndDate(any(), anyInt(), any())).thenReturn(listOfPrices);

        Price response = searchBestPriceAtDate.findBestPriceAtDate(ZARA, 1, LocalDateTime.now());

        assertEquals(1, response.getBrand().getBrandId());
        assertEquals(1, response.getProductId());
        assertEquals((short) 1, response.getRateType());
        assertEquals((short) 1, response.getPriority());
        assertNotNull(response.getStartDate());
        assertNotNull(response.getEndDate());
        assertEquals(BigDecimal.valueOf(35.50), response.getAmount());
        assertEquals(EUR, response.getCurrency());

        verify(priceRepository).findPriceByBrandAndProductIdAndDate(any(), anyInt(), any());
    }

    @Test
    void shouldReturnBestPriceWithHigherPriority_whenFindTwoProductsWithPricesInSameDateRange() {
        List<Price> listOfPrices = List.of(
                Price.builder()
                        .brand(ZARA)
                        .productId(1)
                        .rateType((short) 1)
                        .priority((short) 0)
                        .startDate(LocalDateTime.now())
                        .endDate(LocalDateTime.now().plusMonths(3))
                        .amount(BigDecimal.valueOf(35.50))
                        .currency(EUR).build(),
                Price.builder()
                        .brand(ZARA)
                        .productId(1)
                        .rateType((short) 1)
                        .priority((short) 1)
                        .startDate(LocalDateTime.now())
                        .endDate(LocalDateTime.now().plusMonths(3))
                        .amount(BigDecimal.valueOf(25.45))
                        .currency(EUR).build()
        );

        when(priceRepository.findPriceByBrandAndProductIdAndDate(any(), anyInt(), any())).thenReturn(listOfPrices);

        Price response = searchBestPriceAtDate.findBestPriceAtDate(ZARA, 1, LocalDateTime.now());

        assertEquals(1, response.getBrand().getBrandId());
        assertEquals(1, response.getProductId());
        assertEquals((short) 1, response.getRateType());
        assertEquals((short) 1, response.getPriority());
        assertNotNull(response.getStartDate());
        assertNotNull(response.getEndDate());
        assertEquals(BigDecimal.valueOf(25.45), response.getAmount());
        assertEquals(EUR, response.getCurrency());

        verify(priceRepository).findPriceByBrandAndProductIdAndDate(any(), anyInt(), any());
    }

    @Test
    void shouldThrowProductNotFoundException_whenSearchNonExistingProduct() {
        when(priceRepository.findPriceByBrandAndProductIdAndDate(any(), anyInt(), any()))
                .thenThrow(new ProductNotFoundException(1, 1, LocalDateTime.now()));

        ProductNotFoundException exception = assertThrows(ProductNotFoundException.class,
                () -> searchBestPriceAtDate.findBestPriceAtDate(ZARA, 1, LocalDateTime.now()));

        assertEquals(1, exception.getBrandId());
        assertEquals(1, exception.getProductId());
        assertNotNull(exception.getApplicationDate());

        verify(priceRepository).findPriceByBrandAndProductIdAndDate(any(), anyInt(), any());
    }
}