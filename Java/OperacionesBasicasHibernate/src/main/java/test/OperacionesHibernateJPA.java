package test;

import com.universidad.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

public class OperacionesHibernateJPA {

    public static void main (String [] args){
    
        PersonaDAO personaDao = new PersonaDAO();
        
        
        //Listar personas
        personaDao.listar();
        
        //Insertar una persona
        /*Persona persona = new Persona();
        persona.setNombre("Hector");
        persona.setApellido("Lavoe");
        persona.setEmail("hector@email.com");
        persona.setTelefono("65634");*/
        
        //personaDao.insertar(persona);
        
        //Editar una persona
        /*Persona persona = new Persona();
        persona.setIdPersona(15);
        
        persona = personaDao.encontrarPersona(persona);
        System.out.println("Persona encontrada = " + persona);
                
        persona.setApellido("Valbuena");
        persona.setEmail("hectorV@email.com");
        
        personaDao.actualizar(persona);*/
        
        //Eliminar una persona
        Persona persona = new Persona();
        persona.setIdPersona(10);
        
        //persona = personaDao.encontrarPersona(persona);
        //System.out.println("Persona encontrada = " + persona);
        personaDao.eliminar(persona);
        
    }
    
}
