package ar.com.api.inmobiliaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ar.com.api.inmobiliaria.services.*;

/**
 * PersonaController
 */
@RestController
public class PersonaController {

    @Autowired
    PersonaService personaService;

    /*@GetMapping("/personas")
    public List<Persona> GetPersonas() {
        List<Persona> lp = personaService.getPersonas();

        return lp;
    }*/
}