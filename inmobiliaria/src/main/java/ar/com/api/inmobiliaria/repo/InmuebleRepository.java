package ar.com.api.inmobiliaria.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.api.inmobiliaria.entities.Inmueble;

/**
 * InmuebleRepository
 */
public interface InmuebleRepository extends JpaRepository<Inmueble, Integer>{

    Inmueble findByTotalAmbientes(int nroAmbientes);

    Inmueble findByCantBaños(int cantBaños);

    Inmueble findByTipoInmueble(String tipo);
    
    Inmueble findByBarrio(String barrio);

    Inmueble findByFinalidad(String fin);
    
}