package com.agharibi.jacksondemoproject.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@JsonTest
@ActiveProfiles("snake")
public class BeerDtoSankeTest extends BaseTest {

    @Test
    void testSanke() throws JsonProcessingException {
        BeerDto dto = getDto();
        String json = objectMapper.writeValueAsString(dto);
        System.err.println(json);
    }
}
