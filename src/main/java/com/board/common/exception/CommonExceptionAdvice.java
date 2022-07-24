package com.board.common.exception;

import com.board.common.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionAdvice {

    @ExceptionHandler(ValidFailureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseMessage validFailureHandler(ValidFailureException e) {
        return validError(e.getMessage(), e.getData(), e.getBindingResult());
    }

    private ResponseMessage validError(String exceptionMessage, Object data, BindingResult bindingResult) {
        return ResponseMessage.VALID_FAILURE_EXCEPTION_MESSAGE(
                HttpStatus.BAD_REQUEST.value()
                , HttpStatus.BAD_REQUEST.getReasonPhrase()
                , exceptionMessage
                , data
                , bindingResult
        );
    }

}
