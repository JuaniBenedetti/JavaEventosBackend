package eventos.eventos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(
        name ="clientes",
        uniqueConstraints = @UniqueConstraint(
                name = "UQ_tipo_nro_documento",
                columnNames = {"tipo_documento", "nro_documento"}
        )
)
public class Cliente extends Persona {

    @OneToOne
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "FK_clientes_usuarios"))
    private Usuario usuario;

    @JsonBackReference
    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.ALL})
    private Set<Evento> eventos = new HashSet<>();
}
