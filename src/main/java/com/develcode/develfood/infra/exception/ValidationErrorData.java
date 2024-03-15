package com.develcode.develfood.infra.exception;

import org.springframework.validation.FieldError;

public class ValidationErrorData {
    private String field;
    private String message;

    public ValidationErrorData(FieldError fieldError) {
        this.field = fieldError.getField();
        this.message = fieldError.getDefaultMessage();
    }
}
