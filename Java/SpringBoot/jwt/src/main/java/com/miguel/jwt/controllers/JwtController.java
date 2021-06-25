package com.miguel.jwt.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1")
public class JwtController {
    
    @GetMapping(path="version")
    public ResponseEntity<Object> version(){
       
       return ResponseEntity.ok("!It works");
   
    }
    
}
