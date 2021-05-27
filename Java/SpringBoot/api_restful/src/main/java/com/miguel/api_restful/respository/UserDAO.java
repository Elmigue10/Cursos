package com.miguel.api_restful.respository;

import com.miguel.api_restful.entities.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {
    
    @Transactional(readOnly=true)
    Optional<User> findByUsername(String username);
    
}
