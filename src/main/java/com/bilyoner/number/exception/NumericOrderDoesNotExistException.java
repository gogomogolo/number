package com.bilyoner.number.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NumericOrderDoesNotExistException extends RuntimeException{
    public NumericOrderDoesNotExistException(String message) {
        super(message);
    }
}
