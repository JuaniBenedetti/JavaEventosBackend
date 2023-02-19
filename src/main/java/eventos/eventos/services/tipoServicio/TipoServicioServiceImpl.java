package eventos.eventos.services.tipoServicio;

import eventos.eventos.model.TipoServicio;
import eventos.eventos.dao.tipoServicio.TipoServicioDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoServicioServiceImpl implements TipoServicioService {

    private final TipoServicioDao tipoServicioDao;

    @Override
    public TipoServicio findTipoServicio(Long idTipoServicio) throws Exception {
        return tipoServicioDao.findById(idTipoServicio).get();
    }

    @Override
    public TipoServicio saveTipoServicio(TipoServicio tipoServicio) throws Exception {
        return tipoServicioDao.save(tipoServicio);
    }

    @Override
    public TipoServicio updateTipoServicio(TipoServicio tipoServicio) throws Exception {
        return tipoServicioDao.save(tipoServicio);
    }

    @Override
    public void deleteTipoServicio(TipoServicio tipoServicio) throws Exception {
        tipoServicioDao.deleteById(tipoServicio.getIdTipoServicio());
    }

    @Override
    public List<TipoServicio> findAllTipoServicio() throws Exception {
        return tipoServicioDao.findAll();
    }
}
