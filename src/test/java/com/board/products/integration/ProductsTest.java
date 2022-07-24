package com.board.products.integration;

import com.board.products.model.dto.ProductsRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductsTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void insertProducts() throws Exception {

        ProductsRequestDto productsRequestDto = ProductsRequestDto.builder()
                                .prodName("tets")
                                .prodPrice(123L)
                                .build();

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productsRequestDto)))
                .andExpect(status().isOk())
                .andDo(print());



    }

    @Test
    void negativePrice() throws Exception {
        ProductsRequestDto productsRequestDto = ProductsRequestDto.builder()
                .prodName("tets")
                .prodPrice(-10L)
                .build();

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productsRequestDto)))
                .andExpect(status().isBadRequest())
                .andDo(print());



    }

}
