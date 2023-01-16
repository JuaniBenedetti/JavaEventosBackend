package eventos.eventos.Web.tipoServicio;

import eventos.eventos.Model.TipoServicio;
import eventos.eventos.Services.tipoServicio.TipoServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tipoServicio")
@RequiredArgsConstructor
public class TipoServicioControllerImpl implements TipoServicioController {

    private final TipoServicioService tipoServicioService;

    @Override
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public TipoServicio saveTipoServicio(@RequestBody @Valid TipoServicio tipoServicio) throws Exception {
        return tipoServicioService.saveTipoServicio(tipoServicio);
    }

    @Override
    @PutMapping("/update")
    public TipoServicio updateTipoServicio(@RequestBody @Valid TipoServicio tipoServicio) throws Exception {
        return tipoServicioService.updateTipoServicio(tipoServicio);
    }

    @Override
    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public TipoServicio findTipoServicio(@RequestParam(name = "idTipoServicio") int idTipoServicio) throws Exception {
        return tipoServicioService.findTipoServicio(idTipoServicio);
    }

    @Override
    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public List<TipoServicio> findAll() throws Exception {
        return tipoServicioService.findAll();
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteTipoServicio(@PathVariable int id) throws Exception {
        tipoServicioService.deleteTipoServicio(id);
    }
}
