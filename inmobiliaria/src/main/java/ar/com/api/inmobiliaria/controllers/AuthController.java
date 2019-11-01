package ar.com.api.inmobiliaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.api.inmobiliaria.excepciones.UsuarioException;
import ar.com.api.inmobiliaria.models.request.LoginRequest;
import ar.com.api.inmobiliaria.models.request.RegisterRequest;
import ar.com.api.inmobiliaria.models.response.JwtResponse;
import ar.com.api.inmobiliaria.models.response.RegisterResponse;
import ar.com.api.inmobiliaria.security.jwt.JWTTokenUtil;
import ar.com.api.inmobiliaria.services.JWTUserDetailsService;
import ar.com.api.inmobiliaria.services.UsuarioService;

/**
 * AuthController
 */
public class AuthController {

    @Autowired
    UsuarioService usuarioService;

    /*
     * @Autowired private AuthenticationManager authenticationManager;
     */
    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private JWTUserDetailsService userDetailsService;

    @PostMapping("auth/register")
    public RegisterResponse postRegister(@RequestBody RegisterRequest req) throws UsuarioException {

        RegisterResponse r = new RegisterResponse();

        if (req.tipoUsuario.equals("Inmobiliaria")) {
            int usuarioId = usuarioService.crearUsuarioInmobiliaria(req.nombre, req.domicilio, req.telefono, req.email,
                req.password);

            r.isOk = true;
            r.message = "El usuario se ha generado con éxito.";
            r.usuarioId = usuarioId;
            return r;

        } else {
            if (req.tipoUsuario.equals("Locatario")) {
                int usuarioId = usuarioService.crearUsuarioLocatario(req.nombre, req.dni, req.email, req.domicilio,
                    req.localidad, req.telefono, req.password);

                r.isOk = true;
                r.message = "El usuario se ha generado con éxito.";
                r.usuarioId = usuarioId;
                return r;
            } 
            else {
                throw new UsuarioException("El tipo de usuario no existe");
            }
        }
    }

    @PostMapping("auth/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
            throws Exception {

        usuarioService.login(authenticationRequest.username, authenticationRequest.password);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.username);

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));

    }
}