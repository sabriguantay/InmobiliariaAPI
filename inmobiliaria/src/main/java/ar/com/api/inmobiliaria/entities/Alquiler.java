package ar.com.api.inmobiliaria.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Alquiler
 */
@Entity
@Table(name = "alquiler")
public class Alquiler {

    @Id
    @Column(name = "alquiler_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int alquilerId;
    @Column(name = "meses_alquiler")
    private int mesesAlquiler;
    private String moneda;
    @Column(name = "monto_total")
    private double montoTotal;

    @JsonIgnore
	@OneToOne
    @JoinColumn(name = "contrato_id", referencedColumnName = "contrato_id")
    private Contrato contrato;

    @JsonIgnore
    @OneToOne(mappedBy = "alquiler", cascade = CascadeType.ALL)
    private Reserva reserva;

    public Alquiler(){

    }

    public int getAlquilerId() {
        return alquilerId;
    }

    public void setAlquilerId(int alquilerId) {
        this.alquilerId = alquilerId;
    }

    public int getMesesAlquiler() {
        return mesesAlquiler;
    }

    public void setMesesAlquiler(int mesesAlquiler) {
        this.mesesAlquiler = mesesAlquiler;
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
        this.montoTotal= montoTotal;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
        this.contrato.setAlquiler(this);
	}

    public Contrato getContrato() {
        return contrato;
    }
}