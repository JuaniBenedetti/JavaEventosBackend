package eventos.eventos.dao.reserva;

import eventos.eventos.dao._CRUD.CRUDDao;
import eventos.eventos.model.Cliente;
import eventos.eventos.model.Reserva;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ReservaDao extends CRUDDao<Reserva> {

    Set<Reserva> findAllByCliente(Cliente cliente) throws Exception;
}
