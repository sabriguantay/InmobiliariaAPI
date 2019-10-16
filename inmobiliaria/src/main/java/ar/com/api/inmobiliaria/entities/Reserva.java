package ar.com.api.inmobiliaria.entities;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * Reserva
 */
@Entity
@Table (name = "reserva")
public class Reserva {

    @Id
    @Column (name ="reserva_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservaId;

    private Date fecha;
    
    @JsonIgnore
    @OneToOne(mappedBy = "locatario", cascade = CascadeType.ALL)
    private Locatario locatarioId;
    
    @JsonIgnore
    @OneToOne(mappedBy = "inmueble", cascade = CascadeType.ALL)
    private Inmueble inmuebleId;

    public Reserva(){
        
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Locatario getLocatarioId() {
        return locatarioId;
    }

    public void setLocatarioId(Locatario locatarioId) {
        this.locatarioId = locatarioId;
    }

    public Inmueble getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(Inmueble inmuebleId) {
        this.inmuebleId = inmuebleId;
    }
    
}