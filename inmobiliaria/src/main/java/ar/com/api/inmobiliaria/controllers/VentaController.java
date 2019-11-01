package ar.com.api.inmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ar.com.api.inmobiliaria.entities.Venta;
import ar.com.api.inmobiliaria.models.request.VentaRequest;
import ar.com.api.inmobiliaria.models.response.VentaResponse;
import ar.com.api.inmobiliaria.services.VentaService;

/**
 * VentaController
 */
@RestController
public class VentaController {

    @Autowired
    VentaService ventaService;

    @PostMapping("/inmobiliaria/inmuebles/venta")
    public VentaResponse postCrearVentaDisponible(@RequestBody VentaRequest req) {
        
        VentaResponse r = new VentaResponse();
        int ventaId = ventaService.crearVenta(req.moneda, req.montoTotal);
        
        r.isOk = true;
        r.message = "La venta se ha creado con éxito.";
        r.ventaId = ventaId;
        return r;
    }

    @PutMapping("/inmobiliaria/inmuebles/venta")
    public VentaResponse updateAlquiler(@PathVariable int id, @RequestBody VentaRequest req) {
        VentaResponse r = new VentaResponse();
        ventaService.updateVenta(req.ventaId, req.moneda, req.montoTotal);

        r.isOk = true;
        r.message = "La venta se ha modificado con éxito.";
        return r;
    }

    @DeleteMapping("/inmobiliaria/inmuebles/venta")
    public VentaResponse deleteVenta(@PathVariable int id) {
        VentaResponse r = new VentaResponse();
        Venta v = ventaService.deleteVenta(id);
        
        r.isOk = true;
        r.message = "Se ha eliminado con éxito.";
        r.ventaId = v.getVentaId();
        return r;
    }
    
    @GetMapping("/inmobiliaria/ventas")
    public List<Venta> getVentas() {
        List<Venta> v = ventaService.getListaVentas();

        return v;
    }
    
}