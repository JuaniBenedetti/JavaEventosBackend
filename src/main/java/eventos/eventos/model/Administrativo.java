package eventos.eventos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @JsonIgnore
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "FK_administrativos_usuarios"))
    private Usuario usuario;

//    @OneToMany(mappedBy = "propietario", cascade = {CascadeType.ALL})
//    private Set<Salon> salones = new HashSet<>();
}
