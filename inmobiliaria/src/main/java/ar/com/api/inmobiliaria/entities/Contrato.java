package ar.com.api.inmobiliaria.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
    @OneToOne(mappedBy = "contrato", cascade = CascadeType.ALL)
    private Venta venta;

    @JsonIgnore
    @OneToOne(mappedBy = "contrato", cascade = CascadeType.ALL)
    private Alquiler alquiler;

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

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Alquiler getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}

}