package com.miguel.api_restful.validator;

import com.miguel.api_restful.dto.UserRequest;
import com.miguel.api_restful.utils.hash.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Service;

//Interface para validar los datos recibidos en la creación de usuarios

@Service
public interface UserValidator {

    void validator(UserRequest request) throws ApiUnprocessableEntity;
    
}
