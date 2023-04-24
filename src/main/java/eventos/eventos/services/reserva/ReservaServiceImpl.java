package eventos.eventos.services.reserva;

import eventos.eventos.dao.reserva.ReservaDao;
import eventos.eventos.model.Cliente;
import eventos.eventos.model.Reserva;
import eventos.eventos.services._CRUD.CRUDServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ReservaServiceImpl extends CRUDServiceImpl<Reserva> implements ReservaService {

    private final ReservaDao reservaDao;

    public ReservaServiceImpl(ReservaDao reservaDao) {
        super(reservaDao);
        this.reservaDao = reservaDao;
    }

    @Override
    public List<Reserva> findAllByCliente(Cliente cliente) throws Exception {
        return this.reservaDao.findAllByCliente(cliente);
    }
}
