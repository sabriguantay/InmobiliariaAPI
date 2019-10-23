package ar.com.api.inmobiliaria.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.api.inmobiliaria.entities.Inmobiliaria;
import ar.com.api.inmobiliaria.entities.Locatario;
import ar.com.api.inmobiliaria.entities.Usuario;

/**
 * UsuarioRepository
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    Usuario findByEmail(String email);

	void save(Inmobiliaria i);

	void save(Locatario l);

	Usuario findByUsername(String username);
    
}