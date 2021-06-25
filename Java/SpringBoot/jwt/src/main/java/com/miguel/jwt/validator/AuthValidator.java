package com.miguel.jwt.validator;

import com.miguel.jwt.exceptions.ApiUnauthorized;
import java.util.Objects;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

@Component
public class AuthValidator {
    
    private static final String CLIENT_CREDENTIALS = "client_credentials";
    
    public void validate(MultiValueMap<String, String>paramMap, 
            String grantType) throws ApiUnauthorized{
    
        if(grantType.isEmpty() || !grantType.equals(CLIENT_CREDENTIALS)){
            message ("El campo gran type es invalido");
        }
        
        if(Objects.isNull(paramMap) || 
                paramMap.getFirst("client_id").isEmpty() ||
                paramMap.getFirst("client_secret").isEmpty()
                ){
        
            message("client_id y/o client_secret invaalidos.");
            
        }
        
    }
    
    private void message(String message) throws ApiUnauthorized {
    
        throw new ApiUnauthorized(message);
        
    }
    
}
