package eventos.eventos.services._CRUD;

import java.util.List;

public interface CRUDService<T> {

    T find(Long id) throws Exception;

    T save(T entity) throws Exception;

    T update(T entity) throws Exception;

    void deleteById(Long id) throws Exception;

    List<T> findAll() throws Exception;
}
