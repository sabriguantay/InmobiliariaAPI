package ar.com.api.inmobiliaria.entities;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Contrato
 */
@Entity
@Table (name = "contrato")
public class Contrato {
    @Id
    @Column (name ="contrato_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contratoId;
    private Date fecha;
    
    @JsonIgnore
    @OneToOne 
    @JoinColumn(name = "reserva_id", referencedColumnName = "reserva_id")
    private Reserva reserva ;

    public Contrato(){

    }

    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }


}
