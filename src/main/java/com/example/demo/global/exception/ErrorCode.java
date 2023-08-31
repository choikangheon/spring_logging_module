package com.example.demo.global.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    INVALID_INPUT_VALUE_BINDING_ERROR(HttpStatus.BAD_REQUEST.value(), "INVALID_INPUT_VALUE");

    private final String code;
    private int status;

    ErrorCode(final int status, final String code) {
        this.status = status;
        this.code = code;
    }

}