package ar.com.api.inmobiliaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.api.inmobiliaria.entities.Contrato;
import ar.com.api.inmobiliaria.models.request.ContratoRequest;
import ar.com.api.inmobiliaria.models.response.ContratoResponse;
import ar.com.api.inmobiliaria.services.ContratoService;

/**
 * ContratoController
 */
public class ContratoController {

    @Autowired
    ContratoService cs;

    @PostMapping("/inmobiliaria/inmueble/alquiler/reserva/contrato")
    public ContratoResponse postContrato(@RequestBody ContratoRequest req) {

        ContratoResponse r = new ContratoResponse();
        int contratoId = cs.crearContrato(req.reservaId);

        r.isOk = true;
        r.message = "El contrato se ha generado con éxito.";
        r.contratoId = contratoId;
        return r;
    }

    @PutMapping("/inmobiliaria/inmueble/alquiler/reserva/contrato")
    public ContratoResponse updateAlquiler(@PathVariable int id, @RequestBody ContratoRequest req) {
        ContratoResponse r = new ContratoResponse();
        cs.updateContrato(req.contratoId, req.reservaId);

        r.isOk = true;
        r.message = "El contrato se ha modificado con éxito.";
        return r;
    }

    @DeleteMapping("/inmobiliaria/inmuebles/alquiler")
    public ContratoResponse deleteAlquiler(@PathVariable int id) {
        ContratoResponse r = new ContratoResponse();
        Contrato c = cs.deleteContrato(id);
        
        r.isOk = true;
        r.message = "Se ha eliminado con éxito.";
        r.contratoId = c.getContratoId();
        return r;
    }
    
}