package ar.com.api.inmobiliaria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Inmobiliaria
 */
@Entity
@Table(name = "inmobiliaria")
public class Inmobiliaria {

    private String nombre;

    @Column(name="usuario_id")
    private int usuarioId;

    
    public String getNombre() {
        return nombre;
	}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    
    
}