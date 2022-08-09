package com.board.users.model.dto;

import lombok.*;

@Getter
@Setter
@Builder @NoArgsConstructor @AllArgsConstructor
public class UsersRequestDto {
    private Long userId;
    private String userName;
}
