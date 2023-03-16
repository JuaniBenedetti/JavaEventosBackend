package eventos.eventos.web.evento;

import eventos.eventos.model.Evento;
import eventos.eventos.services.evento.EventoService;
import eventos.eventos.web._CRUD.CRUDControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evento")
public class EventoControllerImpl extends CRUDControllerImpl<Evento> implements EventoController{

    public EventoControllerImpl(EventoService eventoService) {
        super(eventoService);
    }
}
