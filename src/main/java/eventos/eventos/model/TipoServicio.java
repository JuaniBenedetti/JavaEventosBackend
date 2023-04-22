package eventos.eventos.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tipos_servicios")
public class TipoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoServicio;

    @NotNull
    private String denominacion;

//    @JsonIgnore
//    @OneToMany(mappedBy = "tipoServicio")
//    private Set<Servicio> servicios = new HashSet<>();
}
