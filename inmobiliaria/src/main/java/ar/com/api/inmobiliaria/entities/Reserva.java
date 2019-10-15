package ar.com.api.inmobiliaria.entities;

/**
 * Reserva
 */

@Entity
@Table (name = "reserva")
public class Reserva {

    @Id
    @Column (name ="reserva_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservaId;   
    
}