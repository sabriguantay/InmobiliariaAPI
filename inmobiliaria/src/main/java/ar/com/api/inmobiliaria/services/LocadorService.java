package ar.com.api.inmobiliaria.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.api.inmobiliaria.entities.*;
import ar.com.api.inmobiliaria.repo.*;

/**
 * LocadorService
 */
public class LocadorService {

    @Autowired
    LocadorRepository repo;

    public Locador buscarPorId(int id) {

        Optional<Locador> l = repo.findById(id);

        if (l.isPresent()) {
            return l.get();
        }
        return null;
    }

    public List<Locador> getListaLocadores() {
        return repo.findAll();

    }

    public void save(Locador l) {
        repo.save(l);
    }

    public Locador crearLocador(int id, String nombre, String dni, String email, String domicilio) {
        Locador l = new Locador();
        l.setId(id);
        l.setNombre(nombre);
        l.setDni(dni);
        l.setEmail(email);
        l.setDomicilio(domicilio);

        repo.save(l);
        return l;
    }

    public void updateLocador(int id, String nombre, String dni, String email, String domicilio) {
        Locador l = this.buscarPorId(id);
        l.setNombre(nombre);
        l.setDni(dni);
        l.setEmail(email);
        l.setDomicilio(domicilio);
        repo.save(l);

    }
}