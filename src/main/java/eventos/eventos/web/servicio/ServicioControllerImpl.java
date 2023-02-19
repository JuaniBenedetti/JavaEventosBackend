package eventos.eventos.Web.servicio;

import eventos.eventos.Model.Servicio;
import eventos.eventos.Services.servicio.ServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/servicio")
@RequiredArgsConstructor
public class ServicioControllerImpl implements ServicioController {

    private final ServicioService servicioService;

    @Override
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Servicio saveTipoServicio(@RequestBody @Valid Servicio servicio) throws Exception {
        System.out.println(servicio);
        return servicioService.saveServicio(servicio);
    }

    @Override
    @PutMapping("/update")
    public Servicio updateTipoServicio(@RequestBody @Valid Servicio servicio) throws Exception {
        return servicioService.updateServicio(servicio);
    }

    @Override
    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public Servicio findServicio(@RequestParam(name = "idServicio") int idServicio) throws Exception {
        return servicioService.findServicio(idServicio);
    }

    @Override
    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Servicio> findAll() throws Exception {
        return servicioService.findAll();
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteServicio(@PathVariable int id) throws Exception {
        servicioService.deleteServicio(id);
    }
}
