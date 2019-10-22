package ar.com.api.inmobiliaria.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.api.inmobiliaria.entities.*;

/**
 * VentaRepository
 */
public interface VentaRepository extends JpaRepository<Venta, Integer> {

    
}