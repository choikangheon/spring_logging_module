package com.example.demo.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class ExceptionHandlerAdvicer {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    private ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>();
        e.getBindingResult().getAllErrors()
                .forEach(c -> errorMap.put(((FieldError) c).getField(), c.getDefaultMessage()));

        ExceptionResponse response = ExceptionResponse.builder()
                .statusCode(ErrorCode.INVALID_INPUT_VALUE_BINDING_ERROR.getStatus())
                .responseCode(ErrorCode.INVALID_INPUT_VALUE_BINDING_ERROR.getCode())
                .responseMap(errorMap)
                .build();
        return new ResponseEntity(response, HttpStatus.valueOf(response.getStatusCode()));
    }
}
