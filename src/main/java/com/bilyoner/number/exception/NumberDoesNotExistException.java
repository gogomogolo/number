package com.bilyoner.number.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NumberDoesNotExistException extends RuntimeException{
    public NumberDoesNotExistException(String message) {
        super(message);
    }
}
