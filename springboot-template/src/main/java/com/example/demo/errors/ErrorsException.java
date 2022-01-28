package com.example.demo.errors;

import org.springframework.http.HttpStatus;

public abstract  class ErrorsException extends RuntimeException {

    public ErrorsException(String message) {
        super(message);
    }
    abstract HttpStatus getStatusCode();

}

