package ar.com.api.inmobiliaria.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ar.com.api.inmobiliaria.models.request.*;
import ar.com.api.inmobiliaria.models.response.*;
import ar.com.api.inmobiliaria.services.*;

/**
 * AlquilerController
 */
@RestController
public class AlquilerController {

    @Autowired
    AlquilerService alquilerService;

    @PostMapping("/inmobiliarias/alquileres")
    public AlquilerResponse postCrearAlquiler(@RequestBody AlquilerCreacionRequest req) {
        
        AlquilerResponse r = new AlquilerResponse();
        alquilerService.crearAlquiler(req.mesesAlquiler, req.moneda, req.montoTotal);
        
        r.isOk = true;
        r.message = "Alquiler creado con exito";
        return r;
    }


}