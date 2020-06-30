package com.bilyoner.number.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceDoesNotExistException extends RuntimeException{
    public ResourceDoesNotExistException(String message) {
        super(message);
    }
}
