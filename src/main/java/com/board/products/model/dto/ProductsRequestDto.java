package com.board.products.model.dto;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor @AllArgsConstructor
public class ProductsRequestDto {
    @NotBlank(message = "상품명은 필수 입력값입니다.")
    private String prodName;

    @PositiveOrZero(message = "0보다 큰 숫자를 입력해주세요.")
    private Long prodPrice;

}
