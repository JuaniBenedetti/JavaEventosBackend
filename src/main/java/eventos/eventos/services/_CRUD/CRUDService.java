package eventos.eventos.services._CRUD;

import java.util.List;

public interface CRUDService<T> {

    T find(Long id);

    T save(T entity) throws Exception;

    T update(T entity);

    void deleteById(Long id);

    List<T> findAll();
}
