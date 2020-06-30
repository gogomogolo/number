package com.bilyoner.number.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NumberAlreadyExistException.class)
    protected ResponseEntity<Object> handleNumberAlreadyExistException(NumberAlreadyExistException exception){

        return buildResponseEntity(
                new ApiError(HttpStatus.NOT_ACCEPTABLE, exception.getMessage(), exception)
        );
    }

    @ExceptionHandler(value = NumberDoesNotExistException.class)
    protected ResponseEntity<Object> handleNumberDoesNotExistException(NumberDoesNotExistException exception){

        return buildResponseEntity(
                new ApiError(HttpStatus.NOT_FOUND, exception.getMessage(), exception)
        );
    }

    @ExceptionHandler(value = NumericOrderDoesNotExistException.class)
    protected ResponseEntity<Object> handleNumericOrderDoesNotExistException(NumericOrderDoesNotExistException exception){

        return buildResponseEntity(
                new ApiError(HttpStatus.BAD_REQUEST, exception.getMessage(), exception)
        );
    }

    @ExceptionHandler(value = ResourceDoesNotExistException.class)
    protected ResponseEntity<Object> handleResourceDoesNotExistException(ResourceDoesNotExistException exception){

        return buildResponseEntity(
                new ApiError(HttpStatus.NOT_FOUND, exception.getMessage(), exception)
        );
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
