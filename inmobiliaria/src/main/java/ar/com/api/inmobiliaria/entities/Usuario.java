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

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

}