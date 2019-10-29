package ar.com.api.inmobiliaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import ar.com.api.inmobiliaria.security.jwt.JWTTokenUtil;
import ar.com.api.inmobiliaria.services.JWTUserDetailsService;
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

    /*
     * @Autowired private AuthenticationManager authenticationManager;
     */
    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private JWTUserDetailsService userDetailsService;

    @PostMapping("/register/usuarios/inmobiliarias")
    public RegistrationResponse postRegisterUserInmobiliaria(@RequestBody UsuarioInmCreacionRequest req) {

        RegistrationResponse r = new RegistrationResponse();
        usuarioService.crearUsuarioInmobiliaria(req.nombre, req.domicilio, req.telefono, req.email, req.password);

        r.isOk = true;
        r.message = "Usuario Inmobiliaria creado con exito";
        return r;
    }

    @PostMapping("/register/usuarios/locatarios")
    public RegistrationResponse postRegisterUserInmobiliariaLocatario(@RequestBody UsuarioLocCreacionRequest req) {

        RegistrationResponse r = new RegistrationResponse();
        usuarioService.crearUsuarioLocatario(req.nombre, req.dni, req.email, req.domicilio, req.localidad, req.telefono,
                req.password);

        r.isOk = true;
        r.message = "Usuario Locatario creado con exito";
        return r;
    }

    @PostMapping("auth/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
            throws Exception {

        usuarioService.login(authenticationRequest.username, authenticationRequest.password);

        final UserDetails userDetails = userDetailsService
            .loadUserByUsername(authenticationRequest.username);

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));

    }


    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuarioPorId(@PathVariable int id) {
        Usuario u = usuarioService.buscarUsuarioPorId(id);
        if (u == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(u);
    }

    @PutMapping ("usuarios/{id}")
    public UsuarioResponse putDatosUsuario(@RequestBody UsuarioUpdateRequest req){
        UsuarioResponse r = new UsuarioResponse();
        usuarioService.updateUsuario(req.id, req.email, req.password);

        r.isOk = true;
        r.message = "Usuario modificado con exito";
        return r;

    }
}