package ar.com.api.inmobiliaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ar.com.api.inmobiliaria.models.request.VentaCreacionRequest;
import ar.com.api.inmobiliaria.models.response.VentaResponse;
import ar.com.api.inmobiliaria.services.VentaService;

/**
 * VentaController
 */
@RestController
public class VentaController {

    @Autowired
    VentaService ventaService;

    @PostMapping("/inmobiliarias/ventas")
    public VentaResponse postCrearVenta(@RequestBody VentaCreacionRequest req) {
        
        VentaResponse r = new VentaResponse();
        ventaService.crearVenta(req.moneda, req.montoTotal);

        
        r.isOk = true;
        r.message = "Venta creada con exito";
        return r;
    }



    


    
    
}