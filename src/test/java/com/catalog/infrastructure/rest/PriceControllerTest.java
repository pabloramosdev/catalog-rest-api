package com.catalog.infrastructure.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /*
-          Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
-          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
    * */

    @Test
    void getPricesTestOne() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14 10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                          "brandId": 1,
                          "productId": 35455,
                          "rateApplied": 1,
                          "startDate": "2020-06-14T00:00:00",
                          "endDate": "2020-12-31T23:59:59",
                          "price": 35.5,
                          "currency": "EUR"
                        }
                        """));
    }

    @Test
    void getPricesTestTwo() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14 16:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                          "brandId": 1,
                          "productId": 35455,
                          "rateApplied": 2,
                          "startDate": "2020-06-14T15:00:00",
                          "endDate": "2020-06-14T18:30:00",
                          "price": 25.45,
                          "currency": "EUR"
                        }
                        """));
    }

    @Test
    void getPricesTestThree() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14 21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                          "brandId": 1,
                          "productId": 35455,
                          "rateApplied": 1,
                          "startDate": "2020-06-14T00:00:00",
                          "endDate": "2020-12-31T23:59:59",
                          "price": 35.5,
                          "currency": "EUR"
                        }
                        """));
    }

    @Test
    void getPricesTestFour() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-15 10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                          "brandId": 1,
                          "productId": 35455,
                          "rateApplied": 3,
                          "startDate": "2020-06-15T00:00:00",
                          "endDate": "2020-06-15T11:00:00",
                          "price": 30.5,
                          "currency": "EUR"
                        }
                        """));
    }

    @Test
    void getPricesTestFive() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-16 21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                          "brandId": 1,
                          "productId": 35455,
                          "rateApplied": 4,
                          "startDate": "2020-06-15T16:00:00",
                          "endDate": "2020-12-31T23:59:59",
                          "price": 38.95,
                          "currency": "EUR"
                        }
                        """));
    }
}