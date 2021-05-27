package com.miguel;

import com.miguel.domain.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Value("${index.saludo}")
    private String mensaje;
    
    @GetMapping("/")
    public String inicio(Model model){
        String saludo = "Hola mundo con Thymeleaf";
        
        Persona persona = new Persona();
        persona.setNombre("Miguel");
        persona.setApellido("Valbuena");
        persona.setEmail("miguel@mail.com");
        persona.setTelefono("434234");
        
        Persona persona2 = new Persona();
        persona2.setNombre("Juan");
        persona2.setApellido("Perez");
        persona2.setEmail("juan@mail.com");
        persona2.setTelefono("545645");
        
        /*ArrayList<Persona> personas = new ArrayList();
        personas.add(persona);
        personas.add(persona2);*/
        List personas = Arrays.asList(persona, persona2);
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("saludo",saludo);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("persona",persona);
        model.addAttribute("personas",personas);
        return "index";
    }
    
}
