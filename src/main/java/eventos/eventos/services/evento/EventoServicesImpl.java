package eventos.eventos.services.evento;

import eventos.eventos.model.Cliente;
import eventos.eventos.model.Evento;
import eventos.eventos.model.Salon;
import eventos.eventos.model.Servicio;
import eventos.eventos.dao.cliente.ClienteDao;
import eventos.eventos.dao.evento.EventoDao;
import eventos.eventos.dao.salon.SalonDao;
import eventos.eventos.dao.servicio.ServicioDao;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EventoServicesImpl implements EventoService{

    private final EventoDao eventoDao;

    @Override
    public void deleteEventoById(long id) throws Exception{
        eventoDao.deleteById(id);
    }
}
