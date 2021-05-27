package com.miguel.api_restful.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class UserRequest implements Serializable{
    
    @JsonProperty("firstName")
    private String firstname;
    @JsonProperty("lastName")
    private String lastname;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    
}
