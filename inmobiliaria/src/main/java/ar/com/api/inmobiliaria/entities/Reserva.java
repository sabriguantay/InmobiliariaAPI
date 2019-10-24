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
    @JoinColumn(name = "alquiler_id", referencedColumnName = "alquiler_id")
    private Alquiler alquiler;
    
    @JsonIgnore
    @JoinColumn(name = "venta_id", referencedColumnName = "venta_id")
    private Venta venta;


    
    @JsonIgnore
    @OneToOne(mappedBy = "reserva", cascade = CascadeType.ALL)
    private Contrato contrato;
   
    public Reserva(){
        
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
