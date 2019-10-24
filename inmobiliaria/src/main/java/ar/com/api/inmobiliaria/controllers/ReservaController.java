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

    @PostMapping("/inmobiliarias/inmueble/alquiler/reserva")
    public ReservaAlquilerResponse postCrearReservaAl(@RequestBody ReservaAlquilerRequest req) {

        ReservaAlquilerResponse r = new ReservaAlquilerResponse();
        reservaService.crearReservaAlquiler(req.id, req.fecha, req.alquiler, req.contrato);

        r.isOk = true;
        r.message = "Reserva exitosa";
        return r;
    }

    @PostMapping("/inmobiliarias/inmueble/venta/reserva")
    public ReservaVentaResponse postCrearReservaV(@RequestBody ReservaVentaRequest req) {
        
        ReservaVentaResponse r = new ReservaVentaResponse();
        reservaService.crearReservaVenta(req.id, req.fecha, req.venta, req.contrato);
        
        r.isOk = true;
        r.message = "Reserva exitosa";
        return r;
    }
}