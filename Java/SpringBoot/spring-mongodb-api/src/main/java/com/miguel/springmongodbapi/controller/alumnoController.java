package com.miguel.springmongodbapi.controller;

import com.miguel.springmongodbapi.model.Alumno;
import com.miguel.springmongodbapi.services.implementations.AlumnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,
        RequestMethod.PUT, RequestMethod.DELETE})
public class alumnoController {

    @Autowired
    private AlumnoServiceImpl alumnoService;

    @GetMapping("")
    public String prueba(){
        return "It works!";
    }

    @PostMapping ("/alumno")
    public String save(@RequestBody Alumno request) throws IOException {
        return alumnoService.save(request.getId(),request.getNombre(),request.getEdad());
    }

    @GetMapping("/alumno/{id}")
    public Alumno findById(@PathVariable("id") String id){
        return alumnoService.findById(id);
    }

    @GetMapping("/alumno")
    public List<Alumno> findAll(){
        return alumnoService.findAll();
    }

    @PutMapping("/alumno/{id}")
    public String edit(@PathVariable("id") String id, @RequestBody Alumno request) throws IOException {
        return alumnoService.edit( id , request.getNombre() , request.getEdad());
    }

    @DeleteMapping("/alumno/{id}")
    public String deleteById(@PathVariable("id") String id) throws IOException {
        return alumnoService.deleteById(id);
    }
}
