package com.example.demo.errors;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ErrorsException{

    public NotFoundException(String message) {
    super(message);
    }

   @Override
    public HttpStatus getStatusCode() {
      return HttpStatus.NOT_FOUND;
    }

}
