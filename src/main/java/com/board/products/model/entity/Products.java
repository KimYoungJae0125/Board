package com.board.products.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder @NoArgsConstructor @AllArgsConstructor
public class Products {

    private Long id;
    private String name;
    private Long price;
    private String content;
    private String writer;
    private LocalDateTime creationTime;

}
