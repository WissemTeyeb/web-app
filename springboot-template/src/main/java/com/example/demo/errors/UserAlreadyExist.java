
package com.example.demo.errors;
import org.springframework.http.HttpStatus;


public class UserAlreadyExist extends ErrorsException {

    public UserAlreadyExist(String message) {
        super(message);
    }
    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }

}
