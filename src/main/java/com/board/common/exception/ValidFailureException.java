package com.board.common.exception;

import lombok.Getter;
import org.springframework.validation.BindingResult;

@Getter
public class ValidFailureException extends RuntimeException {

    private Object data;
    private BindingResult bindingResult;

    public ValidFailureException(String msg, Object data, BindingResult bindingResult) {
        super(msg);
        this.data = data;
        this.bindingResult = bindingResult;
    }

}
