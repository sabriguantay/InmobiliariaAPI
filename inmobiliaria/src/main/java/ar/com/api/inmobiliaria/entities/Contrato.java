package ar.com.api.inmobiliaria.entities;

import java.util.*;

import javax.persistence.*;

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

    @Column (name = "fecha_inicio")
    private Date fechaInicio;
    

    /*@OneToOne
    @JoinColumn(name = "inmueble_id", referencedColumnName = "inmueble_id")
    private Inmueble inmueble;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;*/

    public Contrato(){

    }

    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }


    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    

}