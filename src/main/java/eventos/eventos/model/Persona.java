package eventos.eventos.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
// @Table(name ="usuarios")
//@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@Id")
public abstract class Usuario {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    @Column
    private String tipoDocumento;

    @Column
    private String nroDocumento;

    @Column
    private String apellido;

    @Column
    private String nombre;

    @Column
    private String mail;

    @Column
    private String telefono;

}
