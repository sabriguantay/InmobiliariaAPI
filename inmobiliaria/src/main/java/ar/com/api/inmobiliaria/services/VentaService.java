package ar.com.api.inmobiliaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.inmobiliaria.repo.*;

/**
 * VentaService
 */
@Service
public class VentaService {

    @Autowired
    VentaRepository repo;


    /*public Venta crearVenta(){
        repo.save();
        return ;
        
    }*/
}