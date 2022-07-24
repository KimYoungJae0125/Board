package com.board.products.model.entity;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@Getter
@Builder @NoArgsConstructor @AllArgsConstructor
public class Products {

    private Long id;
    private String name;
    private Long price;

}
