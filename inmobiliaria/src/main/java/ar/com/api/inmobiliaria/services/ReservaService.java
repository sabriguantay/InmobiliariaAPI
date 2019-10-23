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

    public void save(Reserva r){
        repo.save(r);
    }

    public Reserva buscarPorId(int id) {
        Optional<Reserva> r = repo.findById(id);

        if (r.isPresent())
            return r.get();
        return null;

    }

    public List<Reserva> getListaInmueblesReservados() {
        return repo.findAll();
    }


    //check: se debe settear la id auto - incrementada¿? 
    public Reserva crearReserva(int id, int fecha, Locatario locatario, Inmueble inmueble ) {
        Reserva r = new Reserva();

        r.setReservaId(id);
        r.setFecha(new Date());
        r.setInmueble(inmueble);
        r.setLocatario(locatario);
        repo.save(r);
        return r;

    }

}