
package com.example.demo.errors;
import org.springframework.http.HttpStatus;


public class DataAlreadyExistForUser extends ErrorsException{

    public DataAlreadyExistForUser(String message) {
        super(message);
    }
    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }

}
