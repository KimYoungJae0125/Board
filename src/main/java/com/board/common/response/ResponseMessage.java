package com.board.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder @NoArgsConstructor @AllArgsConstructor
public class ResponseMessage<T> {

    private LocalDateTime transactionTime;
    private int statusCode;
    private String responseMessage;
    private String description;
    private T data;
    private List<ErrorFiled> errors;

    @Getter
    @Builder @AllArgsConstructor @NoArgsConstructor
    public static class ErrorFiled {

        private String filed;
        private String reason;
        private Object value;

        public static List<ErrorFiled> of(BindingResult bindingResult){
            return bindingResult.getAllErrors().stream()
                    .map(error -> new ErrorFiled(
                                    ((FieldError) error).getField()
                                    , ((FieldError) error).getDefaultMessage()
                                    , ((FieldError) error).getArguments()
                            )
                    ).collect(Collectors.toList());
        }

    }

    public static <T> ResponseMessage<T> VALID_FAILURE_EXCEPTION_MESSAGE(int statusCode, String responseMessage, String description, T data, BindingResult bindingResult){

        return ResponseMessage.<T>builder()
                .transactionTime(LocalDateTime.now())
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .description(description)
                .data(data)
                .errors(ErrorFiled.of(bindingResult))
                .build();
    }

    public static <T> ResponseMessage<T> NOT_VALID_ERROR(int statusCode, String responseMessage, T data, BindingResult bindingResult){
        return ResponseMessage.<T>builder()
                .transactionTime(LocalDateTime.now())
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .description("올바른 필드값을 입력했는지 확인해 주세요")
                .data(data)
                .errors(ErrorFiled.of(bindingResult))
                .build();
    }

    public static <T> ResponseMessage<T> OK(int statusCode, String responseMessage){
        return ResponseMessage.<T>builder()
                .transactionTime(LocalDateTime.now())
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .build();
    }
    public static <T> ResponseMessage<T> OK(int statusCode, String responseMessage, String description){
        return ResponseMessage.<T>builder()
                .transactionTime(LocalDateTime.now())
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .description(description)
                .build();
    }
    public static <T> ResponseMessage<T> OK(int statusCode, String responseMessage, T data, BindingResult bindingResult){
        return ResponseMessage.<T>builder()
                .transactionTime(LocalDateTime.now())
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .data(data)
                .build();
    }
    public static <T> ResponseMessage<T> OK(int statusCode, String responseMessage, String description, T data){
        return ResponseMessage.<T>builder()
                .transactionTime(LocalDateTime.now())
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .description(description)
                .data(data)
                .build();
    }
    public static ResponseEntity SUCCESS(String message) {
        return ResponseEntity.ok().body(ResponseMessage.OK(200, HttpStatus.OK.getReasonPhrase(), message));
    }
    public static <T> ResponseEntity<ResponseMessage<T>> SUCCESS(String message, T data) {
        return ResponseEntity.ok().body(ResponseMessage.OK(200, HttpStatus.OK.getReasonPhrase(), message, data));
    }



}
