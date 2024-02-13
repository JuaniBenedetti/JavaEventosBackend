package eventos.eventos.services.reserva;

import eventos.eventos.dao.reserva.ReservaDao;
import eventos.eventos.exceptions.ReservaException;
import eventos.eventos.model.Cliente;
import eventos.eventos.model.Reserva;
import eventos.eventos.model.Salon;
import eventos.eventos.services._CRUD.CRUDServiceImpl;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl extends CRUDServiceImpl<Reserva> implements ReservaService {

    private final ReservaDao reservaDao;

    public ReservaServiceImpl(ReservaDao reservaDao) {
        super(reservaDao);
        this.reservaDao = reservaDao;
    }

    @Override
    public Reserva save(Reserva reserva) throws ReservaException {
        var idSalon = reserva.getSalon().getIdSalon();
        if(findFechasReservadasByIdSalon(idSalon).stream()
                .anyMatch(freserva -> freserva.toLocalDate().equals(reserva.getFechaEvento().toLocalDate()))) {
            throw new ReservaException("No se pudo registrar la reserva: la fecha solicitada ya ha sido agendada.");
        } else {
            return reservaDao.save(reserva);
        }
    }

    @Override
    public List<Reserva> findAllByCliente(Cliente cliente) {
        return this.reservaDao.findAllByCliente(cliente);
    }

    @Override
    public Set<ZonedDateTime> findFechasReservadasByIdSalon(Long idSalon) {
        return reservaDao.findFechasReservadasByIdSalon(idSalon).stream()
                .map(reserva -> reserva.getFechaEvento())
                .collect(Collectors.toSet());
    }
}
