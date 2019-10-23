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
    private Date fecha;
    

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    

}