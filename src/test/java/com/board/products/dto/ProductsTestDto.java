package com.board.products.dto;

import com.board.products.model.dto.ProductsRequestDto;
import com.board.users.model.dto.UsersRequestDto;

import java.time.LocalDateTime;

public class ProductsTestDto {

    public ProductsRequestDto success() {
        return ProductsRequestDto.builder()
                .productName("상품 이름")
                .productPrice(123L)
                .productContent("상품 내용")
                .productWriter(UsersRequestDto.builder().userId(1L).build())
                .productCreationTime(LocalDateTime.now())
                .build();
    }

    public ProductsRequestDto negativePrice() {
        return ProductsRequestDto.builder()
                .productName("상품 이름")
                .productPrice(-123L)
                .productContent("상품 내용")
                .productWriter(UsersRequestDto.builder().userId(1L).build())
                .productCreationTime(LocalDateTime.now())
                .build();
    }

}
