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

    public int crearReservaAlquiler(int id, int fecha, Alquiler alquiler, Contrato contrato) {
        Reserva r = new Reserva();

        r.setReservaId(id);
        r.setFecha(new Date());
        r.setAlquiler(alquiler);
        r.setContrato(contrato);

        repo.save(r);
        return r.getReservaId();
    }

    public void updateReservaAlquiler (int id, int fecha, Alquiler alquiler, Contrato contrato){
        Reserva r = buscarPorId(id);
        r.setReservaId(id);
        r.setFecha(new Date());
        r.setAlquiler(alquiler);
        r.setContrato(contrato);
        
        repo.save(r);
    }

    public Reserva deleteReservaAlquiler(int id) {
        Reserva r = buscarPorId(id);

        repo.save(r);
        return r;
    }

    public int crearReservaVenta(int id, int fecha, Venta venta, Contrato contrato) {
        Reserva r = new Reserva();

        r.setReservaId(id);
        r.setFecha(new Date());
        r.setVenta(venta);
        r.setContrato(contrato);

        repo.save(r);
        return r.getReservaId();
    }
    
    public void updateReservaVenta (int id, int fecha, Venta venta, Contrato contrato){
        Reserva r = new Reserva();

        r.setReservaId(id);
        r.setFecha(new Date());
        r.setVenta(venta);
        r.setContrato(contrato);

        repo.save(r);
    }
    
    public Reserva deleteReservaVenta(int id) {
        Reserva r = buscarPorId(id);

        repo.save(r);
        return r;
    }
}