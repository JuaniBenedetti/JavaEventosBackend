package eventos.eventos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(
        name ="administrativos",
        uniqueConstraints = @UniqueConstraint(
                name = "UQ_tipo_nro_documento",
                columnNames = {"tipo_documento", "nro_documento"}
        )
)
public class Administrativo extends Persona {

    @OneToOne
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "FK_administrativos_usuarios"))
    private Usuario usuario;

//    @OneToMany(mappedBy = "propietario", cascade = {CascadeType.ALL})
//    private Set<Salon> salones = new HashSet<>();
}
