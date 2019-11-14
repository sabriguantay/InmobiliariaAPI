package ar.com.api.inmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ar.com.api.inmobiliaria.entities.Alquiler;
import ar.com.api.inmobiliaria.models.request.*;
import ar.com.api.inmobiliaria.models.response.*;
import ar.com.api.inmobiliaria.services.*;

/**
 * AlquilerController ////////////
 */
@RestController
public class AlquilerController {

    @Autowired
    AlquilerService alquilerService;

    @PostMapping("/inmobiliaria/inmuebles/alquiler")
    public AlquilerResponse postCrearAlquiler(@RequestBody AlquilerRequest req) {
        
        AlquilerResponse r = new AlquilerResponse();
        int alquilerId = alquilerService.crearAlquiler(req.mesesAlquiler, req.moneda, req.montoTotal);
        
        r.isOk = true;
        r.message = "El alquiler se ha creado con éxito.";
        r.alquilerId = alquilerId;
        return r;
    }

    @PutMapping("/inmobiliaria/inmuebles/alquiler")
    public AlquilerResponse updateAlquiler(@PathVariable int id, @RequestBody AlquilerRequest req) {
        AlquilerResponse r = new AlquilerResponse();
        alquilerService.updateAlquiler(req.alquilerId, req.moneda, req.montoTotal);

        r.isOk = true;
        r.message = "El alquiler se ha modificado con éxito.";
        return r;
    }

    @DeleteMapping("/inmobiliaria/inmuebles/alquiler")
    public AlquilerResponse deleteAlquiler(@PathVariable int id) {
        AlquilerResponse r = new AlquilerResponse();
        Alquiler a = alquilerService.deleteAlquiler(id);
        
        r.isOk = true;
        r.message = "Se ha eliminado con éxito.";
        r.alquilerId = a.getAlquilerId();
        return r;
    }

    @GetMapping("/inmobiliaria/alquiler")
    public List<Alquiler> getAlquileres(){
        List<Alquiler> a = alquilerService.getListaAlquileres();
        return a;
    }
}