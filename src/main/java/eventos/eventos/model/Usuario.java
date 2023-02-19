package eventos.eventos.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    @Column(nullable = false)
    @Type(type = "true_false")
    private Boolean activo = false;

    @ManyToMany
    @JoinTable(
            name = "roles_usuarios",
            joinColumns = @JoinColumn(
                    name = "id_usuario", referencedColumnName = "idUsuario",
                    foreignKey = @ForeignKey(name = "FK_roles_usuarios_usuarios")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_rol", referencedColumnName = "idRol",
                    foreignKey = @ForeignKey(name = "FK_roles_usuarios_roles")
            )
    )
    private Set<RolUsuario> roles = new HashSet<>();
}
