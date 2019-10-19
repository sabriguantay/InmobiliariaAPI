package ar.com.api.inmobiliaria.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.api.inmobiliaria.entities.Inmueble;

import java.util.*;



/**
 * InmuebleRepository
 */
public interface InmuebleRepository extends JpaRepository<Inmueble, Integer>{

 List<Inmueble> findAllByTotalAmbientes(int nroAmbientes);

    List<Inmueble> findAllByCantBanios(int cantBanios);

    List<Inmueble> findAllByTipoInmueble(String tipo);
    
    List<Inmueble> findAllByBarrio(String barrio);

    List<Inmueble> findAllByFinalidad(String finalidad);

    List<Inmueble>  findAllOrderByImporte();

    List<Inmueble> findAllByLocalidad(String localidad);

    List<Inmueble> findAllByNroDormitorios(int nroDorm);   
    
}
