package com.miguel.api_restful.services.implementations;

import com.miguel.api_restful.dto.UserDTO;
import com.miguel.api_restful.dto.UserRequest;
import com.miguel.api_restful.entities.User;
import com.miguel.api_restful.respository.UserDAO;
import com.miguel.api_restful.services.interfaces.IUserService;
import com.miguel.api_restful.utils.hash.BCrypt;
import com.miguel.api_restful.utils.helpers.MHelpers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserImpl implements IUserService{

    @Autowired
    private UserDAO userDAO;
    
    @Override
    public List<UserDTO> findAll() {
        
        List<UserDTO> dto = new ArrayList<>();
        Iterable<User> users = this.userDAO.findAll();
        
        for(User user: users){
        
            UserDTO userDTO = MHelpers.modelMapper().map(user, UserDTO.class);
            
            dto.add(userDTO);
        }

        
        return dto;

    }

    @Override
    public UserDTO findByUsername(String username) {
        
        Optional<User> users = this.userDAO.findByUsername(username);
        
        if(!users.isPresent()){
            return null;
        }
        
        return MHelpers.modelMapper().map(users.get(), UserDTO.class);

    }

    @Override
    public UserDTO findById(int id) {

        Optional<User> users = this.userDAO.findById(id);
        
        if(!users.isPresent()){
            return null;
        }
        
        return MHelpers.modelMapper().map(users.get(), UserDTO.class);

    }

    @Override
    public void save(UserRequest user) {

        User userToSave = MHelpers.modelMapper().map(user, User.class);
        
        userToSave.setPassword(BCrypt.hashpw(user.getPassword(), 
                BCrypt.gensalt()));
        
        this.userDAO.save(userToSave);

    }
    
    @Override
    public void update(UserRequest request, int id){
        Optional<User> user = this.userDAO.findById(id);
        
        User userToUpdate = user.get();
        
        userToUpdate.setFirstName(request.getFirstname());
        userToUpdate.setLastName(request.getLastname());
        userToUpdate.setUsername(request.getUsername());
        
        if(!request.getPassword().isEmpty()){
            userToUpdate.setPassword(BCrypt.hashpw(request.getPassword(), 
                BCrypt.gensalt()));
        }
        
        this.userDAO.save(userToUpdate);
    }

    @Override
    public void saveAll(List<UserRequest> users) {

        List<User> usersToSave = new ArrayList<>();
        
        for(UserRequest u: users){
            
            User user = MHelpers.modelMapper().map(u, User.class);
            
            usersToSave.add(user);
        }
        
        this.userDAO.saveAll(usersToSave);

    }

    @Override
    public void deleteById(int id) {

        this.userDAO.deleteById(id);

    }
    
    private UserDTO converToUserDTO(final User user){
        return MHelpers.modelMapper().map(user, UserDTO.class);
    }
    
}
