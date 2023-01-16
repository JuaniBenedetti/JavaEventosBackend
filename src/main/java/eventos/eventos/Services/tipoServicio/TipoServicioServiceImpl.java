package eventos.eventos.Services.tipoServicio;

import eventos.eventos.Model.TipoServicio;
import eventos.eventos.dao.tipoServicio.TipoServicioDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TipoServicioServiceImpl implements TipoServicioService {

    private final TipoServicioDao tipoServicioDao;

    @Override
    public TipoServicio saveTipoServicio(TipoServicio tipoServicio) throws Exception {
        return tipoServicioDao.saveAndFlush(tipoServicio);
    }

    @Override
    public TipoServicio updateTipoServicio(TipoServicio tipoServicio) throws Exception {
        return tipoServicioDao.saveAndFlush(tipoServicio);
    }

    @Override
    public TipoServicio findTipoServicio(int idTipoServicio) throws Exception {
        return tipoServicioDao.findById(idTipoServicio);
    }

    @Override
    public List<TipoServicio> findAll() throws Exception {
        return tipoServicioDao.findAll();
    }

    @Override
    public void deleteTipoServicio(int id) throws Exception {
        tipoServicioDao.deleteById(id);
    }
}
