package ar.com.api.inmobiliaria.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.api.inmobiliaria.entities.Contrato;
import ar.com.api.inmobiliaria.entities.Reserva;
import ar.com.api.inmobiliaria.repo.ContratoRespository;

/**
 * ContratoService
 */
public class ContratoService {

    @Autowired
    ContratoRespository repo;

    public void save(Contrato c) {
        repo.save(c);
    }

    public Contrato buscarPorId(int id) {
        Optional<Contrato> r = repo.findById(id);

        if (r.isPresent())
            return r.get();
        return null;
    }

    public List<Contrato> getListaContratos() {
        return repo.findAll();
    }


    public int crearContrato(int reservaId){
        Contrato c = new Contrato();
        Date fecha = new Date();
        c.setFecha(fecha);
        Reserva r = new Reserva();
        r.setReservaId(reservaId);
        
        repo.save(c);
        return c.getContratoId();
    }

    public void updateContrato(int contratoId, int reservaId){
        Contrato c = buscarPorId(contratoId);
        Date fecha = new Date();
        c.setFecha(fecha);
        Reserva r = new Reserva();
        r.setReservaId(reservaId);

        repo.save(c);
    }

    public Contrato deleteContrato(int id) {
        Contrato c = buscarPorId(id);
        repo.save(c);

        return c;
    }
}