package ar.com.api.inmobiliaria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.inmobiliaria.entities.*;
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

    public Usuario buscarUsuarioPorId(int id) {
        Optional<Usuario> i = repo.findById(id);

        if (i.isPresent())
            return i.get();
        return null;

    }

    private Usuario crearUsuario(String email, String password) {
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setPassword(password);
        repo.save(u);

        return u;
    }

    public Usuario crearUserInmobiliaria(String nombre, String email, String password) {
        Inmobiliaria i = new Inmobiliaria();
        i.setNombre(nombre);
        Usuario u = us.crearUsuario(email, password);
        i.setUsuario(u);
        repo.save(i);

        return i;

    }

    public Inmobiliaria updateInmobiliaria(String nombre) {
        Inmobiliaria i = new Inmobiliaria();
        i.setNombre(nombre);
        repo.save(i);
        return i;
    }

    public Usuario crearUserLocatario(String email, String password) {
        Locatario l = new Locatario();
        Usuario u = us.crearUsuario (email, password);
        l.setUsuario(u);
        repo.save(l);

        return l;

    }

}
