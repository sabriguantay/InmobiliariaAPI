package ar.com.api.inmobiliaria.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Inmueble
 */
@Entity
@Table(name = "inmueble")
@NamedQuery(name = "Inmueble.findAllByTotalAmbientes", query = "SELECT i FROM Inmueble i WHERE i.total_ambientes = ?1")
@NamedQuery(name = "Inmueble.findAllByCantBanios", query = "SELECT i FROM Inmueble i WHERE i.cantidad_baños = ?1")
@NamedQuery(name = "Inmueble.findAllByBarrio", query = "SELECT i FROM Inmueble i WHERE i.barrio like CONCAT('%',?1,'%')")
@NamedQuery(name = "Inmueble.findAllByMoneda", query = "SELECT i FROM Inmueble i WHERE i.moneda like CONCAT('%', ?1,'%')")
@NamedQuery(name = "Inmueble.findAllByLocalidad", query = "SELECT i FROM Inmueble i WHERE i.localidad like CONCAT('%',?1,'%')")
@NamedQuery(name = "Inmueble.findAllByNroDormitorios", query = "SELECT i FROM Inmueble i WHERE i.nro_dormitorios = ?1")
@NamedQuery(name = "Inmueble.findAllBySuperficie", query = "SELECT i FROM Inmueble i WHERE i.superficie_total = ?1")
@NamedQuery(name = "Inmueble.findAllByFinalidad", query = "SELECT i FROM Inmueble i WHERE i.finalidad like CONCAT('%',?1,'%')")
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
    private String estado; // disponible o reservado

    @Column(name = "cantidad_baños")
    private int cantBanios;
    private int finalidad; // venta o alquiler
    private String detalles;
    private String barrio;

    @ManyToOne
    @JoinColumn(name = "locador_id", referencedColumnName = "locador_id")
    private Locador locador;

    @ManyToOne
    @JoinColumn(name = "inmobiliaria_id", referencedColumnName = "inmobiliaria_id")
    private Inmobiliaria inmobiliaria;

    @JsonIgnore
    @OneToOne(mappedBy = "inmueble", cascade = CascadeType.ALL)
    private Venta venta;

    @JsonIgnore
    @OneToOne(mappedBy = "inmueble", cascade = CascadeType.ALL)
    private Alquiler alquiler;

    public Inmueble() {
    }

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

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
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

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }

    public Inmobiliaria getInmobiliaria() {
        return inmobiliaria;
    }

    public void setInmobiliaria(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
        this.inmobiliaria.setInmueble(this);
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