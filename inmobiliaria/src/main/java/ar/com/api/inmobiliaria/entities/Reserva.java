package ar.com.api.inmobiliaria.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
    @JoinColumn(name = "alquiler_id", referencedColumnName = "alquiler_id")
    private Alquiler alquiler;
    
    @JsonIgnore
    @JoinColumn(name = "venta_id", referencedColumnName = "venta_id")
    private Venta venta;

    @JsonIgnore
    @OneToOne(mappedBy = "locatario", cascade = CascadeType.ALL)
    private Locatario locatario;
    
    @JsonIgnore
    @OneToOne(mappedBy = "inmueble", cascade = CascadeType.ALL)
    private Inmueble inmueble;

    public Reserva(){
        
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }
    
    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
        this.alquiler.setReserva(this); 
    }
    
    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
        this.venta.setReserva(this);
    }

    public Venta getVenta() {
        return venta;
    }
}