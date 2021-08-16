package com.miguel.springmongodbapi.services.interfaces;

import com.miguel.springmongodbapi.model.Alumno;

import java.io.IOException;
import java.util.List;

public interface AlumnoServiceI {

    public String save (String id, String nombre, int edad) throws IOException;

    public Alumno findById(String id);

    public List<Alumno> findAll();

    public String edit (String id, String nombre, int edad) throws IOException;

    public String deleteById(String id);
}
