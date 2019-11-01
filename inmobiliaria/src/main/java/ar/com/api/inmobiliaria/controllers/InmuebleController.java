package ar.com.api.inmobiliaria.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import ar.com.api.inmobiliaria.services.*;
import ar.com.api.inmobiliaria.entities.*;
import ar.com.api.inmobiliaria.models.request.InmuebleRequest;
import ar.com.api.inmobiliaria.models.response.*;

/**
 * InmuebleController
 */
@RestController
public class InmuebleController {

    @Autowired
    InmuebleService is;

    @PostMapping("/inmuebles")
    public InmuebleResponse postInmueble(@RequestBody InmuebleRequest req) {
        InmuebleResponse r = new InmuebleResponse();
        int inmuebleId = is.crearInmueble(req.moneda, req.valor, req.tipoInmueble, req.direccion, req.superficieTotal,
                req.totalAmbientes, req.nroDormitorios, req.cantBanios, req.finalidad, req.detalles, req.barrio);

        r.isOk = true;
        r.message = "Inmueble se ha generado con éxito.";
        r.inmuebleId = inmuebleId;
        return r;
    }

    @GetMapping("/inmuebles/searchbarrio=")
    public ResponseEntity<List<Inmueble>> getInmuebleByBarrio(
            @RequestParam(value = "barrio", required = false) String barrio) {
        List<Inmueble> li = new ArrayList<Inmueble>();
        is.buscarInmueblesPorBarrio(barrio);

        if (barrio == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(li);
    }

    @GetMapping("/inmuebles/searchtipoInmueble=")
    public ResponseEntity<List<Inmueble>> getInmuebleByTipoInmueble(
            @RequestParam(value = "tipoInmueble", required = false) String tipo) {
        List<Inmueble> li = new ArrayList<Inmueble>();
        is.buscarPorTipoInmueble(tipo);

        if (tipo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(li);
    }

    @GetMapping("/inmuebles/searchTotalAmbientes=")
    public ResponseEntity<List<Inmueble>> getInmuebleByTotalAmbientes(
            @RequestParam(value = "totalAmbientes", required = false) int totalAmb) {
        List<Inmueble> li = new ArrayList<Inmueble>();
        is.buscarInmueblesPorTotalAmbientes(totalAmb);

        if (totalAmb < 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(li);
    }

    @PutMapping("/inmuebles")
    public InmuebleResponse updateInmueble(@PathVariable int id, @RequestBody InmuebleRequest req) {
        InmuebleResponse r = new InmuebleResponse();
        is.updateInmueble(req.inmuebleId, req.moneda, req.valor, req.detalles, req.estado);

        r.isOk = true;
        r.message = "Inmueble se ha modificado con éxito.";
        return r;
    }

    @DeleteMapping("/inmobiliaria")
    public InmuebleResponse deleteInmueble(@PathVariable int id){
        InmuebleResponse r = new InmuebleResponse();
        Inmueble i = is.deleteInmueble(id);
        
        r.isOk = true;
        r.message = "Se ha eliminado con éxito.";
        r.inmuebleId = i.getInmuebleId();
        return r;
    }
}