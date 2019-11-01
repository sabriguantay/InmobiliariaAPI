package ar.com.api.inmobiliaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ar.com.api.inmobiliaria.entities.Reserva;
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

    @PostMapping("/inmobiliaria/inmueble/alquiler/reserva")
    public ReservaAlquilerResponse postCrearReservaAl(@RequestBody ReservaAlquilerRequest req) {

        ReservaAlquilerResponse r = new ReservaAlquilerResponse();
        reservaService.crearReservaAlquiler(req.id, req.fecha, req.alquiler, req.contrato);

        r.isOk = true;
        r.message = "La reserva se ha generado con éxito.";
        return r;
    }

    @PutMapping("/inmobiliaria/inmuebles/alquiler/reserva")
    public ReservaAlquilerResponse updateReservaAlquiler(@PathVariable int id, @RequestBody ReservaAlquilerRequest req) {
        ReservaAlquilerResponse r = new ReservaAlquilerResponse();
        reservaService.updateReservaAlquiler(req.id, req.fecha, req.alquiler, req.contrato);

        r.isOk = true;
        r.message = "La reserva de alquiler se ha modificado con éxito.";
        return r;
    }

    @DeleteMapping("/inmobiliaria/inmuebles/alquiler/reserva")
    public ReservaAlquilerResponse deleteReservaAlquiler(@PathVariable int id) {
        ReservaAlquilerResponse r = new ReservaAlquilerResponse();
        Reserva reserva = reservaService.deleteReservaAlquiler(id);
        
        r.isOk = true;
        r.message = "Se ha eliminado con éxito.";
        r.reservaId = reserva.getReservaId();
        return r;
    }

    @PostMapping("/inmobiliaria/inmueble/venta/reserva")
    public ReservaVentaResponse postCrearReservaV(@RequestBody ReservaVentaRequest req) {
        
        ReservaVentaResponse r = new ReservaVentaResponse();
        reservaService.crearReservaVenta(req.id, req.fecha, req.venta, req.contrato);
        
        r.isOk = true;
        r.message = "La reserva se ha generado con éxito.";
        return r;
    }

    @PutMapping("/inmobiliaria/inmuebles/alquiler/venta")
    public ReservaVentaResponse updateReservaVenta(@PathVariable int id, @RequestBody ReservaVentaRequest req) {
        ReservaVentaResponse r = new ReservaVentaResponse();
        reservaService.updateReservaVenta(req.id, req.fecha, req.venta, req.contrato);

        r.isOk = true;
        r.message = "La reserva de venta se ha modificado con éxito.";
        return r;
    }

    @DeleteMapping("/inmobiliaria/inmuebles/alquiler/venta")
    public ReservaVentaResponse deleteReservaVenta(@PathVariable int id) {
        ReservaVentaResponse r = new ReservaVentaResponse();
        Reserva reserva = reservaService.deleteReservaVenta(id);
        
        r.isOk = true;
        r.message = "Se ha eliminado con éxito.";
        r.ventaId = reserva.getReservaId();
        return r;
    }
}