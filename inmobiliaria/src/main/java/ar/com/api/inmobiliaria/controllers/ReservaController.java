package ar.com.api.inmobiliaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ar.com.api.inmobiliaria.models.request.*;
import ar.com.api.inmobiliaria.models.response.*;
import ar.com.api.inmobiliaria.services.ReservaService;

/**
 * ReservaController
 */
@RestController
public class ReservaController {

@Autowired 
ReservaService reservaService;

@PostMapping("/inmobiliarias/inmueble/reserva")
    public ReservaResponse postCrearReserva(@RequestBody ReservaCreacionRequest req) {
        
        ReservaResponse r = new ReservaResponse();
        reservaService.crearReserva(req.id, req.fecha, req.locatario, req.inmueble);

        
        r.isOk = true;
        r.message = "Venta creada con exito";
        return r;
    }



    
}