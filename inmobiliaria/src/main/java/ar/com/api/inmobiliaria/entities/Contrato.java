package ar.com.api.inmobiliaria.entities;

/**
 * Contrato
 */

@Entity
@Table (name = "contrato")
public class Contrato {
    @Id
    @Column (name ="contrato_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contratoId;

    @Column (name = "duracion_contrato_mese")
    private int duracion;
    @Column (name = "fecha_inicio")
    private Date fechaInicio;
    @Column (name = "finalizacion")
    private Date fechaFinalizacion;
    @Column (name = "inmueble_id")
    private int inmuebleId;
    @Column (name = "usuario_id")
    private int usuarioId;
    
    
}