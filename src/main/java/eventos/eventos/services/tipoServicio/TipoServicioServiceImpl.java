package eventos.eventos.services.tipoServicio;

import eventos.eventos.dao.tipoServicio.TipoServicioDao;
import eventos.eventos.model.TipoServicio;
import eventos.eventos.services._CRUD.CRUDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TipoServicioServiceImpl extends CRUDServiceImpl<TipoServicio> implements TipoServicioService {

    public TipoServicioServiceImpl(TipoServicioDao tipoServicioDao) {
        super(tipoServicioDao);
    }
}
