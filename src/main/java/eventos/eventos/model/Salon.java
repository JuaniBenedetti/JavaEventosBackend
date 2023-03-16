package eventos.eventos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name ="salones")
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalon;

    @NotNull
    private String denominacion;

    @NotNull
    private Integer capacidad;

    @NotNull
    private String calleDireccion;

    @NotNull
    private Integer numeroDireccion;

    private double costoPorDia;

    private String nombreImagen;

    @NotNull
    @ManyToOne
    @JsonIgnore
    @JoinColumn(
            name = "id_administrativo",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_salones_administrativos"))
    private Administrativo propietario;
}
