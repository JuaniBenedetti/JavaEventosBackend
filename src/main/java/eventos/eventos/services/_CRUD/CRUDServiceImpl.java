package eventos.eventos.services._CRUD;

import eventos.eventos.dao._CRUD.CRUDDaoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class CRUDService<T> {

    private final CRUDDaoImpl<T> crudDao;

//    @Override
//    public TipoServicio findTipoServicio(Long idTipoServicio) throws Exception {
//        return tipoServicioDao.findById(idTipoServicio).get();
//    }
//
//    @Override
//    public TipoServicio saveTipoServicio(TipoServicio tipoServicio) throws Exception {
//        return tipoServicioDao.save(tipoServicio);
//    }
//
//    @Override
//    public TipoServicio updateTipoServicio(TipoServicio tipoServicio) throws Exception {
//        return tipoServicioDao.save(tipoServicio);
//    }
//
//    @Override
//    public void deleteTipoServicio(TipoServicio tipoServicio) throws Exception {
//        tipoServicioDao.deleteById(tipoServicio.getIdTipoServicio());
//    }
//
//    @Override
//    public List<TipoServicio> findAllTipoServicio() throws Exception {
//        return tipoServicioDao.findAll();
//    }
}
