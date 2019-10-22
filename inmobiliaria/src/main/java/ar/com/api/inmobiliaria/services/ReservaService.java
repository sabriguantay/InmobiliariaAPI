package ar.com.api.inmobiliaria.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.inmobiliaria.entities.*;
import ar.com.api.inmobiliaria.repo.ReservaRepository;

/**
 * ReservaService
 */
@Service
public class ReservaService {

    @Autowired
    ReservaRepository repo;

    public Reserva buscarPorId(int id) {
        Optional<Reserva> r = repo.findById(id);

        if (r.isPresent())
            return r.get();
        return null;

    }

    public List<Reserva> getInmueblesReservados() {
        return repo.findAll();
    }

    public Reserva crearReserva(int id, Date fecha, Locatario locatario, Inmueble inmueble ) {
        Reserva r = new Reserva();

        r.setReservaId(id);
        r.setFecha(new Date());
        r.setInmuebleId(inmueble);
        r.setLocatarioId(locatario);
        repo.save(r);
        return r;

    }

}