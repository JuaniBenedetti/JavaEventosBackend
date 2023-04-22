package eventos.eventos.services.reserva;

import eventos.eventos.model.Cliente;
import eventos.eventos.model.Reserva;
import eventos.eventos.services._CRUD.CRUDService;

import java.util.Set;

public interface ReservaService extends CRUDService<Reserva> {

    Set<Reserva> findAllByCliente(Cliente cliente) throws Exception;
}
