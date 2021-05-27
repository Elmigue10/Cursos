package com.miguel.api_restful.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UserDTO implements Serializable{
    
    private int Id;
    private String firstName;
    private String lastName;
    private String username;
    private Date createdAt;
    private Date updatedAt;
    
}
