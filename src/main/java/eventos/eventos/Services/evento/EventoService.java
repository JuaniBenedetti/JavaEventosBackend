package eventos.eventos.Services.evento;

import eventos.eventos.Model.Evento;

import java.util.List;

public interface EventoService {
    List<Evento> findEventos() throws Exception;

    Evento findEventosById(long id) throws Exception;

    Evento newEvento(Evento evento) throws Exception;

    Evento updateEvento(Evento evento) throws Exception;

    void deleteEventoById( long id) throws Exception;

}
