package eventos.eventos.web.reserva;

import eventos.eventos.model.Reserva;
import eventos.eventos.model.Salon;
import eventos.eventos.web._CRUD.CRUDController;

import java.time.ZonedDateTime;
import java.util.Set;

public interface ReservaController extends CRUDController<Reserva> {

    Set<ZonedDateTime> findFechasReservadasByIdSalon(Long idSalon);
}
