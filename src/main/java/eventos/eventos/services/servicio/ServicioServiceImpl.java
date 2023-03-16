package eventos.eventos.services.servicio;

import eventos.eventos.dao.servicio.ServicioDao;
import eventos.eventos.model.Servicio;
import eventos.eventos.services._CRUD.CRUDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ServicioServiceImpl extends CRUDServiceImpl<Servicio> implements ServicioService{

    public ServicioServiceImpl(ServicioDao servicioDao) {
        super(servicioDao);
    }
}
