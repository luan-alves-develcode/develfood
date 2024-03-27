package com.develcode.develfood.infra.exception;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.develcode.develfood.exception.ValidationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleErrorNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorData>> handleErrorArgumentNotValid(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors();

        return ResponseEntity.badRequest().body(errors.stream().map(ValidationErrorData::new).toList());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleErrorValidationException(ValidationException exception) {
        var errors = exception.getMessage();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
    }

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<String> handleJWTVerificationException(JWTVerificationException exception) {
        var errors = exception.getMessage();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errors);
    }
}
