package ar.com.api.inmobiliaria.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.inmobiliaria.entities.*;
import ar.com.api.inmobiliaria.repo.*;

/**
 * VentaService
 */
@Service
public class VentaService {

    @Autowired
    VentaRepository repo;

    public void save(Venta v) {
        repo.save(v);
    }

    public Venta buscarPorId(int id) {
        Optional<Venta> r = repo.findById(id);

        if (r.isPresent())
            return r.get();
        return null;

    }

    public List<Venta> getListaVentas() {
        return repo.findAll();
    }

    public void crearVenta(String moneda, double monto) {
        Venta v = new Venta();
        v.setMoneda(moneda);
        v.setMontoTotal(monto);
        repo.save(v);

    }


    public void updateVenta (int ventaId, String moneda, double montoTotal){
        Venta v = buscarPorId(ventaId);
        v.setMoneda(moneda);
        v.setMontoTotal(montoTotal);
        repo.save(v);
    }
}