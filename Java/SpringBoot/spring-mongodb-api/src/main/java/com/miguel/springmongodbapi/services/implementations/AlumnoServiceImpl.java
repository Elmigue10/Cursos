package com.miguel.springmongodbapi.services.implementations;

import com.miguel.springmongodbapi.model.Alumno;
import com.miguel.springmongodbapi.repository.AlumnoRepository;
import com.miguel.springmongodbapi.services.interfaces.AlumnoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoServiceI {

    @Autowired
    private AlumnoRepository alumnoRepo;

    @Override
    public String save(String id, String nombre, int edad) throws IOException{

        String mensaje;
        Alumno alumno = new Alumno(id, nombre, edad);

        try{
            alumno =  alumnoRepo.insert(alumno);
            mensaje = "Alumno agredado.";
        } catch (Exception e){
            mensaje = "No se pudo agregar el alumno";
        }
        return mensaje;
    }

    @Override
    public Alumno findById(String id) {
        return alumnoRepo.findById(id).get();
    }

    @Override
    public List<Alumno> findAll(){
        return alumnoRepo.findAll();
    }

    @Override
    public String edit(String id, String nombre, int edad){
        Alumno alumno = new Alumno(id, nombre, edad);
        alumnoRepo.save(alumno);
        return "Alumno actualizado.";
    }

    @Override
    public String deleteById(String id) {
        String mensaje;
        try{
            alumnoRepo.deleteById(id);
            mensaje = "Alumno eliminado.";
        } catch (Exception e){
            mensaje = "No se pudo eliminar el alumno";
        }
        return mensaje;
    }
}
