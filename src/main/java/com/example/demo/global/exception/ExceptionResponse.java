package com.example.demo.global.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse<T>{
    @JsonIgnore
    private int statusCode;
    private String responseCode;
    private String responseMessage;
    private Map<String,String> responseErrors;

    @Builder
    public ExceptionResponse(int statusCode, String responseCode, String responseMessage, Map<String, String> responseErrors) {
        this.statusCode = statusCode;
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseErrors = responseErrors;
    }
}
