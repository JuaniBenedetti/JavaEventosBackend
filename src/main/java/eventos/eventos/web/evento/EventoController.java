package eventos.eventos.Web.evento;

import eventos.eventos.Model.Evento;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EventoController {
    List<Evento> getEventos() throws Exception;

    Evento getEventosById( long id) throws Exception;

    Evento newEvento(Evento evento)throws Exception;
}
