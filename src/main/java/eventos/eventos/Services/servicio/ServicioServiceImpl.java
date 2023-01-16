package eventos.eventos.Services.servicio;

import eventos.eventos.Model.Servicio;
import eventos.eventos.dao.servicio.ServicioDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ServicioServiceImpl implements ServicioService{

    private final ServicioDao servicioDao;

    @Override
    public Servicio saveServicio(Servicio servicio) throws Exception {
        return servicioDao.saveAndFlush(servicio);
    }

    @Override
    public Servicio updateServicio(Servicio servicio) throws Exception {
        return servicioDao.saveAndFlush(servicio);
    }

    @Override
    public Servicio findServicio(int idServicio) throws Exception {
        return servicioDao.findById(idServicio);
    }

    @Override
    public List<Servicio> findAll() throws Exception {
        return servicioDao.findAll();
    }

    @Override
    public void deleteServicio(int id) throws Exception {
        servicioDao.deleteById(id);
    }
}
