package ar.com.api.inmobiliaria.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.inmobiliaria.entities.*;
import ar.com.api.inmobiliaria.repo.InmobiliariaRepository;

/**
 * InmobiliariaService
 */
@Service
public class InmobiliariaService {

    @Autowired
    InmobiliariaRepository repo;

    public void save(Inmobiliaria i) {
        repo.save(i);
    }

    public Inmobiliaria buscarPorId(int id) {

        Optional<Inmobiliaria> i = repo.findById(id);

        if (i.isPresent()) {
            return i.get();
        }
        return null;
    }

    public int crearInmobiliaria(String nombre, String domicilio, int telefono, String email) {

        Inmobiliaria i = new Inmobiliaria();
        i.setNombre(nombre);
        i.setDomicilio(domicilio);
        i.setTelefono(telefono);
        i.setEmail(email);

        repo.save(i);
        return i.getId();
    }

    public void updateDatosInmobiliaria(int id, String nombre, String domicilio, int telefono) {
        Inmobiliaria i = this.buscarPorId(id);
        i.setNombre(nombre);
        i.setDomicilio(domicilio);
        i.setTelefono(telefono);

        repo.save(i);

    }

    public Inmobiliaria deleteInmobiliaria(int id) {
        Inmobiliaria i = this.buscarPorId(id);
        repo.save(i);
        return i;
    }

}