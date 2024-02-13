package eventos.eventos.services.reserva;

import eventos.eventos.exceptions.ReservaException;
import eventos.eventos.model.Cliente;
import eventos.eventos.model.Reserva;
import eventos.eventos.model.Salon;
import eventos.eventos.services._CRUD.CRUDService;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

public interface ReservaService extends CRUDService<Reserva> {

    Reserva save(Reserva reserva) throws ReservaException;

    List<Reserva> findAllByCliente(Cliente cliente);

    Set<ZonedDateTime> findFechasReservadasByIdSalon(Long idSalon);
}
