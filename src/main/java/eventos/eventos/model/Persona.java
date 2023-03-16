package eventos.eventos.model;

import com.sun.istack.NotNull;
import eventos.eventos.model.enums.TipoDocumento;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@MappedSuperclass
@NoArgsConstructor
public abstract class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @NotNull
    @Column(name = "tipo_documento", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @NotNull
    @Column(name="nro_documento", nullable = false, length = 15)
    private String nroDocumento;

    private String apellido;

    private String nombre;

    private LocalDate fechaNacimiento;

    private String telefono;
}
