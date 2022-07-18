package com.board.common.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Products {
    private Long prod_id;
    private String prod_name;
    private Long prod_price;

}
