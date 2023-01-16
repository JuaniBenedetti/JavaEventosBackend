package eventos.eventos.dao.cliente;

import eventos.eventos.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import eventos.eventos.Model.Evento;

import java.util.List;

public interface ClienteDao extends JpaRepository<Cliente, Long> {


    Cliente findClienteByApellido(String apellido);
}
