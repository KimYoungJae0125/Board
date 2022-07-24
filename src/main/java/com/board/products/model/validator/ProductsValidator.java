package com.board.products.model.validator;

import com.board.common.exception.ValidFailureException;
import com.board.products.model.dto.ProductsRequestDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductsValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(ProductsRequestDto.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(errors.hasErrors()) {
          throw new ValidFailureException("상품 등록에 실패하였습니다.", (ProductsRequestDto) target, (BindingResult) errors);
        }

    }

}
