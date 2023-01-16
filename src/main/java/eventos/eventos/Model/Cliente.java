package eventos.eventos.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="clientes")
//@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@Id")
public class Cliente extends Usuario{

    @JsonBackReference
    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.ALL})
    private List<Evento> eventos = new ArrayList<>();

//    @JsonBackReference
//    @OneToMany(mappedBy = "tipoServicio", cascade = {CascadeType.ALL})
//    private List<Servicio> servicios = new ArrayList<>();
}
