package com.board.products.integration;

import com.board.products.dto.ProductsTestDto;
import com.board.products.model.dao.ProductsDao;
import com.board.products.model.dto.ProductsRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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

    @Autowired
    private ProductsDao productsDao;
    private ProductsTestDto productsTestDto;


    @BeforeEach
    void setUp() {
        productsTestDto = new ProductsTestDto();
    }

    @Test
    @DisplayName("상품 등록")
    void insertProducts() throws Exception {

        ProductsRequestDto productsRequestDto = productsTestDto.success();

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productsRequestDto)))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    @DisplayName("상품가격이 0보다 작음")
    void negativePrice() throws Exception {
        ProductsRequestDto productsRequestDto = productsTestDto.negativePrice();

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productsRequestDto)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    @DisplayName("Patch Method를 이용하여 업데이트")
    void updateProducts() throws Exception {
        ProductsRequestDto productsRequestDto = ProductsRequestDto.builder()
                                                                .productName("상품 이름 변경")
                                                                .productPrice(300L)
                                                                .build();

        mockMvc.perform(patch("/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productsRequestDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
