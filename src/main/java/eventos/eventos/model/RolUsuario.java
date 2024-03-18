package eventos.eventos.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import eventos.eventos.model.enums.Rol;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "roles")
public class RolUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Rol nombre;
}
