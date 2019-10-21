package ar.com.api.inmobiliaria.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Locador
 */
public class Locador extends Persona{  

    public Locador(){
        
    }
    @Id
    @Column(name="locador_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int locadorId;
  
    public int getLocadorId() {
        return locadorId;
    }

    public void setLocadorId(int locadorId) {
        this.locadorId = locadorId;
    }

  
}
