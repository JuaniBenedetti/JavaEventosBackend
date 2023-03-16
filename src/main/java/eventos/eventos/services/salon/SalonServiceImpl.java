package eventos.eventos.services.salon;

import eventos.eventos.dao.salon.SalonDao;
import eventos.eventos.model.Evento;
import eventos.eventos.model.Salon;
import eventos.eventos.services._CRUD.CRUDServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonServiceImpl extends CRUDServiceImpl<Salon> implements SalonService {

    public SalonServiceImpl(SalonDao salonDao) { super(salonDao); }
}
