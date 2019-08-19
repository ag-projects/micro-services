package com.agharibi.jacksondemoproject.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    BeerDto getDto() {
        return BeerDto.builder()
                .beerName("BeerName")
                .beerStyle("ALE")
                .id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .price(new BigDecimal("12.96"))
                .upc(123456L)
                .myLocalDate(LocalDate.now())
                .build();
    }
}
