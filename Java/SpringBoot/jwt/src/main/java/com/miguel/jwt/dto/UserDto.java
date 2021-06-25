package com.miguel.jwt.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class UserDto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String uid;
    private String firstName;
    private String lastName;
    private String role;
    private String country;
    
}
