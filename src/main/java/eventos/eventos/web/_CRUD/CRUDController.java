package eventos.eventos.web._CRUD;

import java.util.List;

public interface CRUDController<T> {

    T find(Long id) throws Exception;
    T save(T entity) throws Exception;


    T update(T entity) throws Exception;

    void deleteById(Long id) throws Exception;

    List<T> findAll() throws Exception;
}
