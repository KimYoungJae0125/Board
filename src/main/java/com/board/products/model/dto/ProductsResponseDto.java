package com.board.products.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductsResponseDto {

    private Long prodId;
    private String prodName;
    private Long prodPrice;

}
