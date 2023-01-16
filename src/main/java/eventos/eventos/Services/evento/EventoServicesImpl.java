package eventos.eventos.Services.evento;

import eventos.eventos.Model.Cliente;
import eventos.eventos.Model.Evento;
import eventos.eventos.Model.Salon;
import eventos.eventos.Model.Servicio;
import eventos.eventos.dao.cliente.ClienteDao;
import eventos.eventos.dao.evento.EventoDao;
import eventos.eventos.dao.salon.SalonDao;
import eventos.eventos.dao.servicio.ServicioDao;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
@Transactional
public class EventoServicesImpl implements EventoService{

    private final EventoDao eventoDao;
    private final SalonDao salonDao;
    private final ClienteDao clienteDao;
    private final ServicioDao servicioDao;

    @Override
    public List<Evento> findEventos() throws Exception{

        return eventoDao.findAll();
    }

    @Override
    public Evento findEventosById(long id)throws Exception{
        return eventoDao.findById(id).get();
    }

    @Override
    public Evento newEvento ( Evento evento )throws Exception{

        // Valida que exista un salon
        long idSalonDb = evento.getSalon().getIdSalon();
        Salon salonDb = salonDao.findById(idSalonDb).orElseThrow(()->new NotFoundException("No existe el salon"));

        // Valida que exista un cliente
        long idClienteDb = evento.getCliente().getIdUsuario();
        Cliente clienteDb = clienteDao.findById(idClienteDb).orElseThrow(()->new NotFoundException("No existe el Cliente ingresado"));

        // Valida que existan los servicios
        List<Servicio> serviciosParam = evento.getServicios();
        if( serviciosParam != null){
            for(Servicio servicio : serviciosParam){
                if(servicioDao.findById(servicio.getIdServicio())==null){
                    throw new Exception("No existe el servicio ingresado");
                }
            }
        }
        // Consultar si es necesario..
        evento.setSalon(salonDb);
        evento.setCliente(clienteDb);
        evento.setServicios(serviciosParam);

        /*if(salonDao.findById(idsalonDb).get() == null){
            throw new Exception("No existe el salon ingresado");
        }*/
        return eventoDao.save(evento);
    }

    @Override
    public Evento updateEvento(Evento evento) throws Exception {

        // Valida que exista un salon
        String nomSalonDb = evento.getSalon().getDenominacion();
        Salon salonDb = salonDao.findSalonByDenominacion(nomSalonDb);
        //.orElseThrow(()->new NotFoundException("No existe el salon"));

        if(salonDb == null){
            throw new Exception("No existe el nombre del salon");
        }
        if(!(evento.getCantidadPersonas() < salonDb.getCapacidad())){
            throw new Exception("La cantidad de personas ingresada es mayor a la capacidad del salon");
        }

        // Valida que exista un cliente
        String nomClienteDb = evento.getCliente().getApellido();
        Cliente clienteDb = clienteDao.findClienteByApellido(nomClienteDb);
        //.orElseThrow(()->new NotFoundException("No existe el Cliente ingresado"));

        if(clienteDb == null){
            throw new Exception("No existe el cliente");
        }

        // Valida que existan los servicios
        List<Servicio> serviciosParam = evento.getServicios();
        List<Servicio> serviciosToSave= new ArrayList<>();
        if( serviciosParam != null){
            for(Servicio servicio : serviciosParam){
                Servicio varlocal = servicioDao.findByDenominacion(servicio.getDenominacion());
                // System.out.println(varlocal);

                if( varlocal==null
                ){
                    throw new Exception("No existe el servicio ingresado");
                }else {
                    serviciosToSave.add(varlocal);
                }
            }
        }
        /*evento.setSalon(salonDb);
        evento.setCliente(clienteDb);
        evento.setServicios(serviciosToSave);*/
        return eventoDao.save(evento);
    }

    @Override
    public void deleteEventoById(long id) throws Exception{
        eventoDao.deleteById(id);
    }

}
