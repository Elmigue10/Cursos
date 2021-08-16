package com.miguel.springmongodbapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "alumno")
public class Alumno {
    @Id
    private String id;

    private String nombre;

    private int edad;

    public Alumno () {}

    public Alumno (String id, String nombre, int edad){
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public int getEdad(){
        return edad;
    }
}
