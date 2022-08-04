package com.board.products.model.entity;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
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
