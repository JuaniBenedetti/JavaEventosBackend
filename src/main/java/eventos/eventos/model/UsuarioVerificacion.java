package eventos.eventos.model;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "usuarios_verificacion")
public class UsuarioVerificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioVerificacion;

    @Column(length = 6)
    private final String codigo;

    @Column
    private final ZonedDateTime fechaHoraExpiracion;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(
            name = "id_usuario",
            nullable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_usuarios_verificacion_usuarios"))
    private Usuario usuario;
}

