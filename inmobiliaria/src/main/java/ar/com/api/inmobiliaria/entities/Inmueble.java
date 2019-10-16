package ar.com.api.inmobiliaria.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Inmueble
 */
@Entity
@Table (name = "inmueble")
public class Inmueble {

    @Id
    @Column (name ="inmueble_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inmuebleId;
    
    private String moneda;
    private double valor;
    private int tipoInmueble;
    private String direccion;
    private int superficieTotal;
    private int totalAmbientes;
    private int nroDormitorios;
    private int cantBaños;
    private int finalidad; //venta o alquiler
    private String detalles;
    private String barrio;

    private int usuarioId;

    public Inmueble(){
    }

    @JsonIgnore
    @OneToOne(mappedBy = "inmueble", cascade = CascadeType.ALL)
    private Contrato contrato;

    public int getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(int inmuebleId) {
        this.inmuebleId = inmuebleId;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(int tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getSuperficieTotal() {
        return superficieTotal;
    }

    public void setSuperficieTotal(int superficieTotal) {
        this.superficieTotal = superficieTotal;
    }

    public int getTotalAmbientes() {
        return totalAmbientes;
    }

    public void setTotalAmbientes(int totalAmbientes) {
        this.totalAmbientes = totalAmbientes;
    }

    public int getNroDormitorios() {
        return nroDormitorios;
    }

    public void setNroDormitorios(int nroDormitorios) {
        this.nroDormitorios = nroDormitorios;
    }

    public int getCantBaños() {
        return cantBaños;
    }

    public void setCantBaños(int cantBaños) {
        this.cantBaños = cantBaños;
    }

    public int getFinalidad() {
        return finalidad;
    }

    public void setFinalidad(int finalidad) {
        this.finalidad = finalidad;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
    
}