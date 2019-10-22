package ar.com.api.inmobiliaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.api.inmobiliaria.models.request.RegistrationRequest;
import ar.com.api.inmobiliaria.models.response.RegistrationResponse;
import ar.com.api.inmobiliaria.services.*interface;

/**
 * UsuarioController
 */
@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;


    @PostMapping("")
    public RegistrationResponse postRegisterUser(@RequestBody RegistrationRequest req) {
        
        RegistrationResponse r = new RegistrationResponse();
        
        r.isOk = true;
        r.message = "Te registraste con exito";
        return r;
    }

    
}