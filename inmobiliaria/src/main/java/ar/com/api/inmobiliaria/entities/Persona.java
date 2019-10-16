package ar.com.api.inmobiliaria.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Persona
 */
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @Column (name ="persona_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personaId;  
    
    @Column (name = "nombre")
    private String fullName;
    private int dni;
    private String direccion;
    private int telefono;
    private String email;
    @Column (name = "tipo_persona")
    private String tipoPersona;

    public Persona(){
    }

    @JsonIgnore
    @OneToOne( mappedBy = "persona", cascade = CascadeType.ALL)
    private Usuario usuario;

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
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

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    
}