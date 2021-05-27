package com.miguel.api_restful.services.interfaces;

import com.miguel.api_restful.dto.UserDTO;
import com.miguel.api_restful.dto.UserRequest;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    
    List<UserDTO> findAll();
    
    UserDTO findByUsername(String username);
    
    UserDTO findById(int id);
    
    void save(UserRequest user);
    
    void update(UserRequest user, int id);
    
    void saveAll(List<UserRequest> users);
    
    void deleteById(int id);
    
}
