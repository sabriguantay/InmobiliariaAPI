package ar.com.api.inmobiliaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ar.com.api.inmobiliaria.entities.Inmobiliaria;
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

    @PostMapping("/inmobiliaria")
    public InmobiliariaResponse crearInmobiliaria(@RequestBody InmobiliariaRequest req){

        InmobiliariaResponse r =  new InmobiliariaResponse();
        int inmobiliariaId = is.crearInmobiliaria(req.nombre, req.domicilio, req.telefono, req.email);

        r.isOk = true;
        r.message = "Inmobiliaria" + req.nombre + " se ha generado con éxito.";
        r.inmobiliariaId = inmobiliariaId;
        return r;
    }

    @PutMapping("/inmobiliaria")
    public InmobiliariaResponse putDatosInmobiliaria(@PathVariable int id, @RequestBody InmobiliariaRequest req) {
        
        InmobiliariaResponse r = new InmobiliariaResponse();
        is.updateDatosInmobiliaria(req.id, req.nombre, req.domicilio, req.telefono);
        
        r.isOk = true;
        r.message = "Los datos de inmobiliaria" + req.nombre + " se han modificado con éxito.";
        return r;
    }
    
    @DeleteMapping("/inmobiliaria")
    public InmobiliariaResponse deleteInmobiliaria(@PathVariable int id){
        InmobiliariaResponse r = new InmobiliariaResponse();
        Inmobiliaria i = is.deleteInmobiliaria(id);
        
        r.isOk = true;
        r.message = "Se ha eliminado con éxito.";
        r.inmobiliariaId = i.getId();
        return r;
    }
    
}