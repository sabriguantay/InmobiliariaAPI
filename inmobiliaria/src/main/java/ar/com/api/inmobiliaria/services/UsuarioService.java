package ar.com.api.inmobiliaria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.inmobiliaria.entities.Inmobiliaria;
import ar.com.api.inmobiliaria.entities.Locatario;
import ar.com.api.inmobiliaria.entities.Usuario;
import ar.com.api.inmobiliaria.repo.UsuarioRepository;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;

    @Autowired
    UsuarioService us;

    @Autowired
    LocatarioService ls;

    public Usuario buscarUsuarioPorId(int id) {
        Optional<Usuario> i = repo.findById(id);

        if (i.isPresent())
            return i.get();
        return null;

    }

    private Usuario crearUsuarioLocatario(String nombre, int dni, String email, String direccion, String localidad,
            int telefono, String password) {

        Locatario l = new Locatario();
        l.setFullName(nombre);
        l.setDni(dni);
        l.setEmail(email);
        l.setDireccion(direccion);
        l.setLocalidad(localidad);
        l.setTelefono(telefono);

        Usuario u = new Usuario();
        u.setUsername(l.getEmail());
        u.setEmail(l.getEmail());
        u.setPassword(password);
        repo.save(u);

        return u;

        /*
         * String passwordEnTextoClaro; String passwordEncriptada; String
         * passwordEnTextoClaroDesencriptado;
         * 
         * passwordEnTextoClaro = password; passwordEncriptada =
         * Crypto.encrypt(passwordEnTextoClaro, u.getUsername());
         * 
         * u.setPassword(passwordEncriptada); l.setUsuario(u); ls.save(l);
         * 
         * return u;
         */
    }

    private Usuario crearUsuarioInmobiliaria(String nombre, int dni, String email, String direccion, String localidad,
            int telefono, String password) {

        Inmobiliaria i = new Inmobiliaria();
        i.setNombre(nombre);
        i.setEmail(email);

        Usuario u = new Usuario();
        u.setUsername(i.getEmail());
        u.setEmail(i.getEmail());
        u.setPassword(password);
        repo.save(u);

        return u;

    }

    public Inmobiliaria updateInmobiliaria(String nombre) {
        Inmobiliaria i = new Inmobiliaria();
        i.setNombre(nombre);
        repo.save(i);
        return i;
    }

    

}
