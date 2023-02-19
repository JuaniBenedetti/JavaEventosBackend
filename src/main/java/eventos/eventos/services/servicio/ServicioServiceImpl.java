package eventos.eventos.services.servicio;

import eventos.eventos.model.Servicio;
import eventos.eventos.dao.servicio.ServicioDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioServiceImpl implements ServicioService{

    private final ServicioDao servicioDao;

    @Override
    public Servicio findServicio(Long idServicio) throws Exception {
        return servicioDao.findById(idServicio).get();
    }

    @Override
    public Servicio saveServicio(Servicio servicio) throws Exception {
        return servicioDao.save(servicio);
    }

    @Override
    public Servicio updateServicio(Servicio servicio) throws Exception {
        return servicioDao.save(servicio);
    }

    @Override
    public void deleteServicio(Servicio servicio) throws Exception {
        servicioDao.deleteById(servicio.getIdServicio());
    }

    @Override
    public List<Servicio> findAllServicio() throws Exception {
        return servicioDao.findAll();
    }
}
