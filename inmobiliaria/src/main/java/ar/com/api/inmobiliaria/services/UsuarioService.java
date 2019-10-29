package ar.com.api.inmobiliaria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import ar.com.api.inmobiliaria.entities.Inmobiliaria;
import ar.com.api.inmobiliaria.entities.Locatario;
import ar.com.api.inmobiliaria.entities.Usuario;
import ar.com.api.inmobiliaria.repo.UsuarioRepository;
//import ar.com.api.inmobiliaria.security.Crypto;
import ar.com.api.inmobiliaria.security.Crypto;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;

    @Autowired
    UsuarioService us;

    public void save(Usuario u) {
        repo.save(u);
    }

    public Usuario buscarUsuarioPorId(int id) {
        Optional<Usuario> i = repo.findById(id);

        if (i.isPresent())
            return i.get();
        return null;

    }

    public Usuario crearUsuarioLocatario(String nombre, String dni, String email, String domicilio, String localidad,
            int telefono, String password) {

        Locatario l = new Locatario();
        l.setNombre(nombre);
        l.setDni(dni);
        l.setEmail(email);
        l.setDomicilio(domicilio);
        l.setLocalidad(localidad);
        l.setTelefono(telefono);

        Usuario u = new Usuario();
        u.setUsername(l.getEmail());
        u.setPassword(password);
        u.setEstado("ACTIVO");
        repo.save(u);

        return u;

    }

    public Usuario crearUsuarioInmobiliaria(String nombre, String domicilio, int telefono, String email,  String password) {

        Inmobiliaria i = new Inmobiliaria();
        i.setNombre(nombre);
        i.setEmail(email);
        i.setDomicilio(domicilio);
        i.setTelefono(telefono);

        Usuario u = new Usuario();
        u.setUsername(i.getEmail());
        u.setPassword(password);
        repo.save(u);

        return u;

    }

    public Usuario updateUsuario(int id, String email, String password) {
        Usuario u = this.buscarUsuarioPorId(id);
        u.setEmail(email);
        u.setUsername(u.getEmail());
        u.setPassword(password);
        repo.save(u);
        return u;
    }


    public Usuario deleteUsuario(int id) {
        Usuario u = this.buscarUsuarioPorId(id);
        u.setEstado("NO ACTIVO");
        repo.save(u);

        return u;
    }

    public Usuario buscarPorUsername(String username) {
        return repo.findByUserName(username);
    }

    public Usuario buscarPorEmail(String email) {
        return repo.findByUserEmail(email);
    }

    public void login(String username, String password) {

        Usuario u = repo.findByUserName(username);

        if (u == null || !u.getPassword().equals(Crypto.encrypt(password, u.getUsername()))) {

            throw new BadCredentialsException("Usuario o contraseña invalida");
        }
    }

    /*
     * public void login(String username, String password) {
     * 
     * Usuario u = repo.findByUsername(username);
     * 
     * if (u == null || !u.getPassword().equals(Crypto.encrypt(password,
     * u.getUsername()))) {
     * 
     * throw new Exception("Usuario o contraseña invalida"); }
     */

}
