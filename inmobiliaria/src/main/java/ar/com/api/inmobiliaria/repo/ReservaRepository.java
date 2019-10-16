package ar.com.api.inmobiliaria.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.api.inmobiliaria.entities.Reserva;
import ar.com.api.inmobiliaria.entities.Usuario;

/**
 * ReservaRepository
 */
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
    
    Reserva findByUsuario(Usuario u);
}