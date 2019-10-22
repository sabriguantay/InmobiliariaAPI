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
        List<Inmueble> li ;
        is.buscarInmueblesPorBarrio(barrio);

        if (barrio == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(li);
    }

    @GetMapping("/inmuebles/tipoInmueble")
    public ResponseEntity<Inmueble> getInmuebleByTipoInmueble(
            @RequestParam(value = "tipoInmueble", required = false) String tipo) {
        List<Inmueble> li;
        is.buscarPorTipoInmueble(tipo);

        if (tipo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(li);
    }

    @GetMapping("/inmuebles/searchTotalAmbientes=")
    public ResponseEntity<Inmueble> getInmuebleByTotalAmbientes(
            @RequestParam(value = "barrio", required = false) int totalAmb) {
        List<Inmueble> li;
        is.buscarInmueblesPorTotalAmbientes(totalAmb);

        if (totalAmb < 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(li);
    }

}
