package eventos.eventos.web._CRUD;

import eventos.eventos.services._CRUD.CRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
public abstract class CRUDControllerImpl<T> implements CRUDController<T>{

    private final CRUDService<T> crudService;

    @Override
    @GetMapping("/find")
    public T find(@RequestParam(name = "id") Long id) throws Exception {
        return crudService.find(id);
    }

    @Override
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public T save(@RequestBody @Valid T entity) throws Exception {
        return crudService.save(entity);
    }

    @Override
    @PutMapping("/update")
    public T update(@RequestBody @Valid T entity) throws Exception {
        return crudService.update(entity);
    }

    @Override
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestParam(name = "id") Long id) throws Exception {
        crudService.deleteById(id);
    }

    @Override
    @GetMapping("/findAll")
    public List<T> findAll() throws Exception {
        return crudService.findAll();
    }
}
