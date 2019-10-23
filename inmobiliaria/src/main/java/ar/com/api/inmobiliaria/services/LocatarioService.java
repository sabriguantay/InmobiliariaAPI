package ar.com.api.inmobiliaria.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.inmobiliaria.entities.Locatario;
import ar.com.api.inmobiliaria.repo.LocatarioRepository;

/**
 * LocatarioService
 */
@Service
public class LocatarioService {

    @Autowired
    LocatarioRepository repo;

    public List<Locatario> getListaLocatario() {
        return repo.findAll();

    }

    public Locatario buscarPorId(int id) {

        Optional<Locatario> l = repo.findById(id);

        if (l.isPresent()) {
            return l.get();
        }
        return null;
    }

    public void save(Locatario l) {
        repo.save(l);
    }

    public void updateDatosPersonalesLocatario(int id, String nombre, String dni, String domicilio, String localidad,
            int telefono) {
        Locatario l = this.buscarPorId(id);
        l.setNombre(nombre);
        l.setDni(dni);
        l.setDomicilio(domicilio);
        l.setLocalidad(localidad);
        l.setTelefono(telefono);

        repo.save(l);
    }

}