package eventos.eventos.dao.reserva;

import eventos.eventos.dao._CRUD.CRUDDao;
import eventos.eventos.model.Cliente;
import eventos.eventos.model.Reserva;
import eventos.eventos.model.Salon;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface ReservaDao extends CRUDDao<Reserva> {

    List<Reserva> findAllByCliente(Cliente cliente);

    @Query("FROM Reserva r WHERE r.salon.idSalon = :idSalon AND r.fechaEvento >= CURRENT_DATE")
    List<Reserva> findFechasReservadasByIdSalon(Long idSalon);
}
