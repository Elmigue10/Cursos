package com.miguel.api_restful.controllers;

import com.miguel.api_restful.dto.UserRequest;
import com.miguel.api_restful.services.interfaces.IUserService;
import com.miguel.api_restful.utils.hash.exceptions.ApiUnprocessableEntity;
import com.miguel.api_restful.validator.UserValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,
        RequestMethod.PUT, RequestMethod.DELETE})
public class ApiController {
    
    @Autowired
    private IUserService userService;
    
    @Autowired
    private UserValidatorImpl userValidator;
    
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index(){
        return ResponseEntity.ok(this.userService.findAll());
    }
    
    @GetMapping(value="/by/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByUsername(@PathVariable("username") String username){
        return ResponseEntity.ok(this.userService.findByUsername(username));
    }
    
    @PostMapping(value="/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveUser(@RequestBody UserRequest request) 
            throws ApiUnprocessableEntity{
    
        this.userValidator.validator(request);
        this.userService.save(request);
        
        return ResponseEntity.ok(Boolean.TRUE);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id){
        
        this.userService.deleteById(id);
        
        return ResponseEntity.ok(Boolean.TRUE);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody UserRequest request,
            @PathVariable("id") int idUser){
        
        this.userService.update(request, idUser);
        
        return ResponseEntity.ok(Boolean.TRUE);
            
    }
    
}
