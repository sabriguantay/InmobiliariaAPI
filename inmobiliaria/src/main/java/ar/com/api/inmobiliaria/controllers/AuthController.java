package ar.com.api.inmobiliaria.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.api.inmobiliaria.models.request.RegistrationRequest;
import ar.com.api.inmobiliaria.models.response.RegistrationResponse;

/**
 * AuthController
 */
@RestController
public class AuthController {

    @PostMapping("auth/register")
    public RegistrationResponse postRegisterUser(@RequestBody RegistrationRequest req) {
        
        RegistrationResponse r = new RegistrationResponse();
        
        r.isOk = true;
        r.message = "Te registraste con exitoooo";
        return r;
    }
}