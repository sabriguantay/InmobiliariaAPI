package ar.com.api.inmobiliaria.entities;

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
 * Venta
 */
@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @Column(name = "venta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ventaId;
    private String moneda;
    @Column(name = "monto_total")
    private double montoTotal;

	@JsonIgnore
	@OneToOne
    @JoinColumn(name = "contrato_id", referencedColumnName = "contrato_id")
    private Contrato contrato;

    @JsonIgnore
    @OneToOne(mappedBy = "venta", cascade = CascadeType.ALL)
    private Reserva reserva;

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

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
        this.contrato.setVenta(this);
	}

    public Contrato getContrato() {
        return contrato;
    }
}
