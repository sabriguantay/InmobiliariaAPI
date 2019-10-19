package ar.com.api.inmobiliaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.inmobiliaria.repo.InmuebleRepository;

/**
 * InmuebleService
 */
@Service
public class InmuebleService {

    @Autowired
    InmuebleRepository repo;

    public int crearInmueble(String moneda, double valor, int tipoInmueble, String direccion,int superficieTotal, int totalAmbientes, int nroDormitorios, int cantBaños, int finalidad, String detalles, String barrio,){
        Inmueble i = new Inmueble();
        i.setMoneda();
        i.setValor();
        i.setTipoInmueble();
        i.setDireccion();
        i.setBarrio();
        i.setSuperficieTotal();
        i.setTotalAmbientes();
        i.setNroDormitorios();
        i.setCantBanios();
        i.setFinalidad();
        i.setDetalles();
        
        repo.save(i);
        return i.getId();
    }

      public List<Inmueble> listarInmuebles(){ 
        return repo.findAll();

    }

      public Inmueble buscarPorId(int id) {

        Optional<Inmueble> i = repo.findById(id);

        if (i.isPresent()) {
            return i.get();
        }
        return null;
    }

    public List<Inmueble> buscarInmueblesOrdenadosPorImporte(){
        return repo.findAllOrderByImporte();
    }

    public List<Inmueble> buscarInmueblesPorBarrio(String barrio){
      return repo.findAllByBarrio(barrio);
        
    }
         
    
      public List<Inmueble> buscarInmueblesPorTipoInmueble(String tipoInm) {
        return repo.findAllByTipoInmueble(tipoInm);
      }
     
      public List<Inmueble> buscarInmueblesPorTotalAmbientes(int totalAmb) {

         return repo.findAllByTotalAmbientes(totalAmb);
5
    }
     
      public List<Inmueble> buscarPorLocalidad(String localidad) {

         return repo.findAllByLocalidad(localidad);
    }

     
      public List<Inmueble> buscarPorFinalidad(int fin) {

        return repo.findAllByFinalidad(fin);
    }


    public List<Inmueble> buscarPorDormitorios(int nroDorm) {

      return repo.findAllByNroDormitorios(nroDorm);
    }
    
}