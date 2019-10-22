package ar.com.api.inmobiliaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.inmobiliaria.repo.*;

/**
 * AlquilerService
 */
@Service
public class AlquilerService {

    @Autowired
    AlquilerRepository repo;

}