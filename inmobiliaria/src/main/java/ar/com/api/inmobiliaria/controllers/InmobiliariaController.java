package ar.com.api.inmobiliaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ar.com.api.inmobiliaria.models.request.*;
import ar.com.api.inmobiliaria.models.response.*;
import ar.com.api.inmobiliaria.services.*;

/**
 * InmobiliariaController
 */
@RestController
public class InmobiliariaController {

    @Autowired
    InmobiliariaService is;

    @PutMapping("/inmobiliaria/")
    public InmobiliariaResponse putDatosInmobiliaria(@RequestBody InmobiliariaUpdateDatosRequest req) {
        
        InmobiliariaResponse r = new InmobiliariaResponse();
        is.updateDatosInmobiliaria(req.id, req.nombre, req.domicilio, req.telefono);
        
        r.isOk = true;
        r.message = "Datos modificados con exito";
        return r;
    }





    
}