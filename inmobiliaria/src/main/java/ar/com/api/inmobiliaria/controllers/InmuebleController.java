package ar.com.api.inmobiliaria.controllers;

/**
 * InmuebleController
 */
@RestController
public class InmuebleController {

    @Autowired
    InmuebleService is;

    @GetMapping("/inmuebles/barrios")
    public ResponseEntity<Inmueble> getInmuebleByBarrio(
            @RequestParam(value = "barrio", required = false) String barrio) {
        List<Inmueble> li;
        inmuebleService.buscarPorBarrio(barrio);

        if (barrio == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(li);
    }

    @GetMapping("/inmuebles/searchtipoInmueble=")
    public ResponseEntity<Inmueble> getInmuebleByBarrio(
            @RequestParam(value = "tipoInmueble", required = false) String barrio) {
        List<Inmueble> li;
        inmuebleService.buscarPorBarrio(barrio);

        if (tipoInmueble == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(li);
    }

    @GetMapping("/inmuebles/searchTotalAmbientes=")
    public ResponseEntity<Inmueble> getInmuebleBy(@RequestParam(value = "barrio", required = false) String barrio) {
        List<Inmueble> li;
        inmuebleService.buscarPorBarrio(barrio);

        if (barrio == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(li);
    }

}