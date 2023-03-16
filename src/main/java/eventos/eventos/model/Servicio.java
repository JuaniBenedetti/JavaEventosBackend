package eventos.eventos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@Table(name ="servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicio;

    @NotNull
    private String denominacion;

    private double costoPorDia;

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "idTipoServicio",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_servicios_tipos_servicios"))
    private TipoServicio tipoServicio;
}
