package com.miguel.api_restful.utils.hash.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepcion perzonalizada de status 404
 * @author Miguel
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiNotFound extends Exception{

    public ApiNotFound(String message){
        super(message);
    }
    
}
