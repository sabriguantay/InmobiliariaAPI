package ar.com.api.inmobiliaria.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.com.api.inmobiliaria.entities.Inmueble;



/**
 * InmuebleRepository
 */
public interface InmuebleRepository extends JpaRepository<Inmueble, Integer>{

    List<Inmueble> findAllByTotalAmbientes(int nroAmbientes);

    List<Inmueble> findAllByCantBanios(int cantBanios);
    
    List<Inmueble> findAllByBarrio(String barrio);

    List<Inmueble> findAllByMoneda(String moneda);

    @Query("select i from Inmueble i order by valor")
    List<Inmueble>  findAllOrderByValor(double valor);

    List<Inmueble> findAllByLocalidad(String localidad);

    List<Inmueble> findAllByNroDormitorios(int nroDorm);   

    List<Inmueble> findAllBySuperficie(int superficie);
    
    List<Inmueble> findAllByFinalidad(String finalidad);

	List<Inmueble> findAllByTipoInmueble(String tipo);
}