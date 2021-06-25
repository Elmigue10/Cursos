package com.miguel.jwt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnauthorized extends Exception {
    
    private static final long serialVersionUID = 5071496619546474611L;
    
    public ApiUnauthorized (String message){
        super(message);
    }
    
}
