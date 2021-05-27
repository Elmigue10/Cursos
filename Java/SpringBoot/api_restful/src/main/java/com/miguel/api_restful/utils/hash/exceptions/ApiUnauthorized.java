package com.miguel.api_restful.utils.hash.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepcion personalziada de status 401
 * @author Miguel
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnauthorized extends Exception{
    
    public ApiUnauthorized(String message){
        super(message);
    }
    
}
