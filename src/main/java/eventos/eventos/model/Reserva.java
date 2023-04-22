package eventos.eventos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name ="eventos")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroReserva;

    private ZonedDateTime fechaReserva;

    @NotNull
    private ZonedDateTime fechaEvento;

    @NotNull
    private Integer cantidadPersonas;

    @ManyToOne
    @JoinColumn(
            name = "id_cliente",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_eventos_clientes")
    )
    private Cliente cliente ;

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "id_salon",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_eventos_salones")
    )
    private Salon salon;

    @ManyToMany
    @JoinTable(
            name = "eventos_servicios",
            joinColumns = @JoinColumn(
                    name = "nro_reserva", referencedColumnName = "nroReserva",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "FK_eventos_servicios_eventos")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_servicio", referencedColumnName = "idServicio",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "FK_eventos_servicios_servicios")
            )
    )
    private Set<Servicio> servicios = new HashSet<>();
}
