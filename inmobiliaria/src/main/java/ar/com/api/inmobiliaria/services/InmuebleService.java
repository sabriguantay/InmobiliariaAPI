package ar.com.api.inmobiliaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.inmobiliaria.entities.*;
import ar.com.api.inmobiliaria.repo.InmuebleRepository;

/**
 * InmuebleService
 */
@Service
public class InmuebleService {

  @Autowired
  InmuebleRepository repo;

  public Inmueble crearInmueble(String moneda, double valor, int tipoInmueble, String direccion, int superficieTotal,
      int totalAmbientes, int nroDormitorios, int cantBanios, int finalidad, String detalles, String barrio) {
    Inmueble i = new Inmueble();
    i.setMoneda(moneda);
    i.setValor(valor);
    i.setTipoInmueble(tipoInmueble);
    i.setDireccion(direccion);
    i.setBarrio(barrio);
    i.setSuperficieTotal(superficieTotal);
    i.setTotalAmbientes(totalAmbientes);
    i.setNroDormitorios(nroDormitorios);
    i.setCantBanios(cantBanios);
    i.setFinalidad(finalidad);
    i.setDetalles(detalles);
    i.setEstado("Disponible");

    repo.save(i);
    return i;
  }

  public List<Inmueble> getListaInmuebles() {
    return repo.findAll();

  }

  public Inmueble buscarPorId(int id) {

    Optional<Inmueble> i = repo.findById(id);

    if (i.isPresent()) {
      return i.get();
    }
    return null;
  }

  public void save(Inmueble i) {
    repo.save(i);
  }

  public List<Inmueble> buscarInmueblesOrdenadosPorValor(double valor) {
    return repo.findAllOrderByValor(valor);
  }

  public List<Inmueble> buscarInmueblesPorBarrio(String barrio) {
    return repo.findAllByBarrio(barrio);

  }

  public List<Inmueble> buscarInmueblesPorTotalAmbientes(int totalAmb) {

    return repo.findAllByTotalAmbientes(totalAmb);

  }

  public List<Inmueble> buscarPorLocalidad(String localidad) {

    return repo.findAllByLocalidad(localidad);
  }

  public List<Inmueble> buscarPorFinalidad(String fin) {

    return repo.findAllByFinalidad(fin);
  }

  public List<Inmueble> buscarPorDormitorios(int nroDorm) {

    return repo.findAllByNroDormitorios(nroDorm);
  }

  public List<Inmueble> buscarPorCantBanios(int banios) {

    return repo.findAllByCantBanios(banios);
  }

  public List<Inmueble> buscarPorTipoInmueble(String tipo) {

    return repo.findAllByTipoInmueble(tipo);
  }

}
