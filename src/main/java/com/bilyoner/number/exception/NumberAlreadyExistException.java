package com.bilyoner.number.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class NumberAlreadyExistException extends RuntimeException {
    public NumberAlreadyExistException(String message) {
        super(message);
    }
}
