package ar.com.api.inmobiliaria.services;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.api.inmobiliaria.entities.Locatario;
import ar.com.api.inmobiliaria.repo.LocadorRepository;

/**
 * LocatarioService
 */
public class LocatarioService {

    @Autowired
    LocadorRepository repo;

	public void save(Locatario l) {
	}

}