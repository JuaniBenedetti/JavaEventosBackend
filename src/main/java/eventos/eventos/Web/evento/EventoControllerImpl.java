package eventos.eventos.Web.evento;

import eventos.eventos.Model.Evento;
import eventos.eventos.Model.Servicio;
import eventos.eventos.Services.evento.EventoServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/eventos")
@RequiredArgsConstructor
public class EventoControllerImpl implements EventoController{


    private final EventoServicesImpl eventoServices;

    @GetMapping("/findEventos")
    public List<Evento> getEventos()throws Exception{
        return eventoServices.findEventos();
    }

    @GetMapping("/findEventos/{id}")
    public Evento getEventosById(@PathVariable long id)throws Exception{
        return eventoServices.findEventosById(id);
    }

    @PostMapping
    public Evento newEvento(@RequestBody @Valid Evento evento) throws Exception {
        return eventoServices.newEvento(evento);
    }

    @PutMapping("/putEventos")
    public Evento updateEvento(@RequestBody @Valid Evento evento) throws Exception {
        return eventoServices.updateEvento(evento);
    }
    @DeleteMapping("/deleteEventos/{id}")
    public void deleteEvento(@PathVariable long id)throws Exception {
        eventoServices.deleteEventoById(id);
    }
}
