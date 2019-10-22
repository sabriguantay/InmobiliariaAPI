package ar.com.api.inmobiliaria.entities;

import javax.persistence.*;


/**
 * Locador
 */
@Entity
@Table(name = "Locador")
public class Locador extends Persona {

    @Id
    @Column(name = "inmobiliaria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String fullName;
    private int dni;

    public Locador() {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}