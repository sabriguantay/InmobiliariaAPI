package ar.com.api.inmobiliaria.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.api.inmobiliaria.entities.Inmobiliaria;

/**
 * InmobiliariaRepository
 */
public interface InmobiliariaRepository extends JpaRepository <Inmobiliaria, Integer>{

    
}