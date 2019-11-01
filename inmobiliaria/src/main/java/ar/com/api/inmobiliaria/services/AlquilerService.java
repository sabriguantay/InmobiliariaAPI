package ar.com.api.inmobiliaria.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.inmobiliaria.entities.*;
import ar.com.api.inmobiliaria.repo.*;

/**
 * AlquilerService
 */
@Service
public class AlquilerService {

    @Autowired
    AlquilerRepository repo;

    public void save(Alquiler a) {
        repo.save(a);
    }

    public Alquiler buscarPorId(int id) {
        Optional<Alquiler> r = repo.findById(id);

        if (r.isPresent())
            return r.get();
        return null;
    }

    public List<Alquiler> getListaAlquileres() {
        return repo.findAll();
    }

    public int crearAlquiler(int mesesAlquiler, String moneda, double montoTotal) {
        Alquiler a = new Alquiler();
        a.setMesesAlquiler(mesesAlquiler);
        a.setMoneda(moneda);
        a.setMontoTotal(montoTotal);

        repo.save(a);
        return a.getAlquilerId();
    }

    public void updateAlquiler (int alquilerId, String moneda, double montoTotal){
        Alquiler a = buscarPorId(alquilerId);
        a.setMoneda(moneda);
        a.setMontoTotal(montoTotal);
        
        repo.save(a);
    }

    public Alquiler deleteAlquiler(int id) {
        Alquiler a = buscarPorId(id);

        repo.save(a);
        return a;
    }
}