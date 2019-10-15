package ar.com.api.inmobiliaria.entities;
import javax.persistence.*;

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

    private int usuarioId;

    






    
}