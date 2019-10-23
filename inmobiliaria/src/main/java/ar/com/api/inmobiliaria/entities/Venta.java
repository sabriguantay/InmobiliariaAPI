package ar.com.api.inmobiliaria.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Venta
 */
@Entity
@Table(name = "alquiler")
public class Venta {

    @Id
    @Column(name = "venta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ventaId;
    private String moneda;
    @Column(name = "monto_total")
    private double montoTotal;

    //@JsonIgnore
    //@OneToOne con la reserva 

    //@JsonIgnore
    //@OneToOne con el contrato


    public Venta(){
        
    }
    
	
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public int getVentaId() {
		return ventaId;
	}

	public void setVentaId(int ventaId) {
		this.ventaId = ventaId;
	}


    
}