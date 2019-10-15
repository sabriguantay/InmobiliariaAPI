package ar.com.api.inmobiliaria.entities;

/**
 * Usuario
 */

@Entity
@Table (name = "usuario")
public class Usuario {

    @Id
    @Column (name ="usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioId;

    private String email;
    private String password;
    @Column (name ="tipo_usuario")
    private  String tipoUsuario; //inmobiliaria o locatario
    @Column (name ="persona_id")
    private int personaId;
    

}