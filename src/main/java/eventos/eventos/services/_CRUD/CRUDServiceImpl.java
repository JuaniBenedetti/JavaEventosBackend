package eventos.eventos.services._CRUD;

import eventos.eventos.dao._CRUD.CRUDDao;
import eventos.eventos.model.enums.Rol;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class CRUDServiceImpl<T> implements CRUDService<T> {

    private final CRUDDao<T> crudDao;

    @Override
    public T find(Long id) {
        return crudDao.findById(id).get();
    }

    @Override
    public T save(T entity) throws Exception {
        return crudDao.save(entity);
    }

    @Override
    public T update(T entity) {
        return crudDao.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        crudDao.deleteById(id);
    }

    @Override
    public List<T> findAll() {
        return crudDao.findAll();
    }
}
