package ar.com.api.inmobiliaria.entities;

/**
 * Persona
 */
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

    


}