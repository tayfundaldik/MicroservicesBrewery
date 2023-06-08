package com.datwashurtt.microservicesbrewery.web.controller;

import com.datwashurtt.microservicesbrewery.domain.Beer;
import com.datwashurtt.microservicesbrewery.web.model.BeerDto;
import com.datwashurtt.microservicesbrewery.web.model.BeerStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/"+ UUID.randomUUID().toString())
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String beerDtoJson =objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception{
        BeerDto beerDto =getValidBeerDto();
        String beerDtoJson =objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/"+ UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJson))
                        .andExpect(status().isNoContent());
    }
    BeerDto getValidBeerDto(){
        return BeerDto.builder()
                .beerName("Galmorph")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("4.99"))
                .upc(13213144141241L)
                .build();
    }
}