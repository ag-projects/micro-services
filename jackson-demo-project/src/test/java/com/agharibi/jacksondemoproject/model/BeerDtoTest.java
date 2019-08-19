package com.agharibi.jacksondemoproject.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

@JsonTest
class BeerDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;


    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto dto = getDto();
        String jsonString  = objectMapper.writeValueAsString(dto);
        System.err.println(jsonString);
    }

    @Test
    void testDeserializeDto() throws IOException {
        String json = "{\"beerId\":\"ac480a2e-0d9b-4884-a19c-0017c773d972\",\"beerName\":\"BeerName\",\"beerStyle\":\"ALE\",\"upc\":123456,\"price\":12.96,\"createdDate\":\"2019-08-19T12:57:57.135286-07:00\",\"lastModifiedDate\":\"2019-08-19T12:57:57.136098-07:00\"}";
        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);
        System.err.println(beerDto);
    }
}