package com.miguel.dao;

import com.miguel.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona, Long>{
    
}
