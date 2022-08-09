package com.board.products.model.dto;

import com.board.users.model.dto.UsersResponseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ProductsResponseDto {

    private Long id;
    private String name;
    private Long price;
    private String content;
    private UsersResponseDto writer;
    private LocalDateTime creationTime;

}
