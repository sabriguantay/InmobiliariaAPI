package ar.com.api.inmobiliaria.entities;

import java.util.*;

import javax.persistence.*;

/**
 * Locatario
 */
@Entity
@Table(name = "locatario")
public class Locatario extends Persona {
    @Id
    @Column(name = "locatario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locatarioId;
    @Column(name = "nombre")
    private String fullName;
    private int dni;
    private String direccion;
    private String localidad;
    private int telefono;
    private String email;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "locatario", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<Reserva>();



    public Locatario() {

    }

    public int getLocatarioId() {
        return locatarioId;
    }

    public void setLocatarioId(int locatarioId) {
        this.locatarioId = locatarioId;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

}