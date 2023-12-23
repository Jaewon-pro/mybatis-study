package com.example.learn.global;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        final ErrorResponse response = ErrorResponse.create(ex, BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(response, response.getStatusCode());
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponse> handleIllegalStateException(IllegalStateException ex) {
        final ErrorResponse response = ErrorResponse.create(ex, UNPROCESSABLE_ENTITY, ex.getMessage());
        return new ResponseEntity<>(response, response.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception ex) {
        final ErrorResponse response = ErrorResponse.create(ex, INTERNAL_SERVER_ERROR, ex.getMessage());
        log.error("기본 ERROR: {}", ex.getMessage());
        return new ResponseEntity<>(response, response.getStatusCode());
    }

}
