package com.miguel.springmongodbapi.repository;

import com.miguel.springmongodbapi.model.Alumno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlumnoRepository extends MongoRepository<Alumno, String> { }
