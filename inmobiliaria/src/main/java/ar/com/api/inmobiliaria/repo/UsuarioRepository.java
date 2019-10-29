package ar.com.api.inmobiliaria.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.api.inmobiliaria.entities.Inmobiliaria;
import ar.com.api.inmobiliaria.entities.Locatario;
import ar.com.api.inmobiliaria.entities.Usuario;

/**
 * UsuarioRepository
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    public Usuario findByUserName(String userName);
    public Usuario findByUserEmail(String email);

	void save(Inmobiliaria i);
	void save(Locatario l);
}