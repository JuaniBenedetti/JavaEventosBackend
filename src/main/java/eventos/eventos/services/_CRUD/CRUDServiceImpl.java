package eventos.eventos.services._CRUD;

import eventos.eventos.dao._CRUD.CRUDDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class CRUDServiceImpl<T> implements CRUDService<T> {

    private final CRUDDao<T> crudDao;

    @Override
    public T find(Long id) throws Exception {
        return crudDao.findById(id).get();
    }

    @Override
    public T save(T entity) throws Exception {
        return crudDao.save(entity);
    }

    @Override
    public T update(T entity) throws Exception {
        return crudDao.save(entity);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        crudDao.deleteById(id);
    }

    @Override
    public List<T> findAll() throws Exception {
        return crudDao.findAll();
    }
}
