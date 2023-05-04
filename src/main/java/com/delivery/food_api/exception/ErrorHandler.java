package com.delivery.food_api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(FoodApiException.class)
    public ResponseEntity error500(FoodApiException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
