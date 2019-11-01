package ar.com.api.inmobiliaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import ar.com.api.inmobiliaria.entities.*;
import ar.com.api.inmobiliaria.models.request.*;
import ar.com.api.inmobiliaria.models.response.*;
import ar.com.api.inmobiliaria.services.UsuarioService;

/**
 * UsuarioController
 */
@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id) {
        Usuario u = usuarioService.buscarUsuarioPorId(id);
        if (u == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(u);
    }

    @PutMapping ("usuarios/{id}")
    public UsuarioResponse putDatosUsuario(@PathVariable int id, @RequestBody UsuarioUpdateRequest req){
        UsuarioResponse r = new UsuarioResponse();
        usuarioService.updateUsuario(req.id, req.email, req.password);

        r.isOk = true;
        r.message = "El usuario ha sido modificado con exito";
        return r;
    }

    @DeleteMapping ("usuarios/{id}")
    public UsuarioResponse deleteUsuario(@PathVariable int id){
        UsuarioResponse r = new UsuarioResponse();
        Usuario u = usuarioService.deleteUsuario(id);

        r.isOk = true;
        r.message = "El usuario se ha eliminado con éxito.";
        r.usuarioId = u.getUsuarioId();
        return r;
    }
}