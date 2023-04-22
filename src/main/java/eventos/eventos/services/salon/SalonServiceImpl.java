package eventos.eventos.services.salon;

import eventos.eventos.dao.salon.SalonDao;
import eventos.eventos.model.Salon;
import eventos.eventos.services._CRUD.CRUDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SalonServiceImpl extends CRUDServiceImpl<Salon> implements SalonService {

    public SalonServiceImpl(SalonDao salonDao) { super(salonDao); }
}
