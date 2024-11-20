package com.hardwin.ecommerce.exception;

import com.hardwin.ecommerce.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException){
        return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(resourceNotFoundException.getMessage(), null));
    }


    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(AlreadyExistsException alreadyExistsException){
        return ResponseEntity.status(CONFLICT).body(new ApiResponse(alreadyExistsException.getMessage(), null));
    }
}
