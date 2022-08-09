package com.board.users.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
@ToString
public class UsersResponseDto {
    private Long id;
    private String name;
}
