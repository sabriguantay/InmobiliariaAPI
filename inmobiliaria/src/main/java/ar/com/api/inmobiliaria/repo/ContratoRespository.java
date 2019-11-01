package ar.com.api.inmobiliaria.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.api.inmobiliaria.entities.*;
/**
 * ContratoRespository
 */
public interface ContratoRespository extends JpaRepository<Contrato, Integer> {

    
}