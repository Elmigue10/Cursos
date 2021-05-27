package com.miguel.api_restful.utils.hash.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepcion perzonalizada de status 422
 */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnprocessableEntity extends Exception{
    
    public ApiUnprocessableEntity(String message){
        super(message);
    }
    
}
