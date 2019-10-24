package ar.com.api.inmobiliaria.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import ar.com.api.inmobiliaria.services.*;
import ar.com.api.inmobiliaria.entities.*;

/**
 * InmuebleController
 */
@RestController
public class InmuebleController {

    @Autowired
    InmuebleService is;

    
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


}
