package eventos.eventos.services.evento;

import eventos.eventos.dao.evento.EventoDao;
import eventos.eventos.model.Evento;
import eventos.eventos.services._CRUD.CRUDServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventoServicesImpl extends CRUDServiceImpl<Evento> implements EventoService{

    public EventoServicesImpl(EventoDao eventoDao) {
        super(eventoDao);
    }
}
