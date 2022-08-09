package com.board.products.model.dto;

import com.board.users.model.dto.UsersRequestDto;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor @AllArgsConstructor
public class ProductsRequestDto {
    private Long productId;
    @NotBlank(message = "상품명은 필수 입력값입니다.")
    private String productName;

    @PositiveOrZero(message = "0보다 큰 숫자를 입력해주세요.")
    private Long productPrice;

    private String productContent;

    private UsersRequestDto productWriter;

    private LocalDateTime productCreationTime;

}
