package com.miguel.dao;

import com.miguel.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDao extends JpaRepository<Persona, Long>{
    
}
