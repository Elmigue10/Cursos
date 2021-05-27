package com.miguel.api_restful.validator;

import com.miguel.api_restful.dto.UserRequest;
import com.miguel.api_restful.utils.hash.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator {

    @Override
    public void validator(UserRequest request) throws ApiUnprocessableEntity {

        if(request.getFirstname() == null || request.getFirstname().isEmpty()){
            message("El nombre es obligatorio.");
        }
        if(request.getFirstname().length() < 3){
            message("El nombre es demasiado corto. Debe tener al menos 3"
                    + "caracteres.");
        }
        if(request.getLastname()== null || request.getLastname().isEmpty()){
            message("El apellido es obligatorio.");
        }
        if(request.getLastname().length() < 3){
            message("El apellido es demasiado corto. Debe tener al menos 3"
                    + "caracteres.");
        }
        if(request.getUsername()== null || request.getUsername().isEmpty()){
            message("El nombre de usuario es obligatorio.");
        }
        if(request.getUsername().length() < 3){
            message("El nombre de usuario es demasiado corto. Debe tener al "
                    + "menos 3 caracteres.");
        }
        if(request.getPassword()== null || request.getPassword().isEmpty()){
            message("La contraseña es obligatoria.");
        }
        if(request.getPassword().length() < 8){
            message("La contraseña es demasiado corta. Debe tener al "
                    + "menos 8 caracteres.");
        }
    }
    
    private void message(String message) throws ApiUnprocessableEntity {
        
        throw new ApiUnprocessableEntity(message);
        
    }
    
}
