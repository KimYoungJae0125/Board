package com.board.products.dto;

import com.board.products.model.dto.ProductsRequestDto;

import java.time.LocalDateTime;

public class ProductsTestDto {

    public ProductsRequestDto success() {
        return ProductsRequestDto.builder()
                .productName("상품 이름")
                .productPrice(123L)
                .productContent("상품 내용")
                .productWriter("tester")
                .productCreationTime(LocalDateTime.now())
                .build();
    }

    public ProductsRequestDto negativePrice() {
        return ProductsRequestDto.builder()
                .productName("상품 이름")
                .productPrice(-123L)
                .productContent("상품 내용")
                .productWriter("tester")
                .productCreationTime(LocalDateTime.now())
                .build();
    }

}
