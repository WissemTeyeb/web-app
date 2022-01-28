package com.example.demo.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionApiHandler extends ResponseEntityExceptionHandler  {

   @ExceptionHandler(ErrorsException.class)
    public ResponseEntity<ErrorResponse> HandleException(ErrorsException ex,  WebRequest request){

      ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorResponse,ex.getStatusCode());

    }


}
