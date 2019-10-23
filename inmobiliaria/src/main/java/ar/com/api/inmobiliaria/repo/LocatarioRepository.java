package ar.com.api.inmobiliaria.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.api.inmobiliaria.entities.*;

/**
 * LocatarioRepository
 */

public interface LocatarioRepository extends JpaRepository<Locatario, Integer>{

    
}