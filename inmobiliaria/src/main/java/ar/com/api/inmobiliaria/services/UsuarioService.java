package ar.com.api.inmobiliaria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.inmobiliaria.entities.Usuario;
import ar.com.api.inmobiliaria.repo.UsuarioRepository;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;

     public Usuario buscarPorId(int id){
        Optional<Usuario> u = repo.findById(id);
        
        if (u.isPresent())
            return u.get();
        return null;

    }

    public void CrearUsuario(String userName, String password, String email) {
        Usuario u = new Usuario();
        u.setUsername(userName);
        u.setPassword(password);
        u.setEmail(email);
        repo.save(u);

    }

    
}