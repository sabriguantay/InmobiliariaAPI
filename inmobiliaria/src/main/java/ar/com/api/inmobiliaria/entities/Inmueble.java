package ar.com.api.inmobiliaria.entities;

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
 * Inmueble
 */
@Entity
@Table (name = "inmueble")
public class Inmueble {

 @Id
    @Column(name = "inmueble_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inmuebleId;

    private String moneda;
    private double valor;
    private int tipoInmueble;
    private String direccion;
    @Column(name = "superficie_total")
    private int superficieTotal;
    @Column(name = "total_ambientes")
    private int totalAmbientes;
    @Column(name = "nro_dormitorios")
    private int nroDormitorios;
    private String localidad;
    private String estado; //disponible o reservado

    @Column(name = "cantidad_baños")
    private int cantBanios;
    private int finalidad; // venta o alquiler
    private String detalles;
    private String barrio;

    @Column(name = "usuario_id")
    private int usuarioId;

    public Inmueble() {
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

    public int getCantBanios() {
        return cantBanios;
    }

    public void setCantBanios(int cantBanios) {
        this.cantBanios = cantBanios;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
