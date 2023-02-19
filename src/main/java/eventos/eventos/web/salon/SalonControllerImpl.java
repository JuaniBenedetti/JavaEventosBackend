package eventos.eventos.Web.salon;

import javax.validation.Valid;
import eventos.eventos.Model.Salon;
import eventos.eventos.Model.TipoServicio;
import eventos.eventos.Services.salones.SalonesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/salas")
@RequiredArgsConstructor
public class SalonControllerImpl implements SalonController {

    private final SalonesService salonesServices;


    @GetMapping("/findSalas")
    public List<Salon> getSalones() throws Exception {
        return salonesServices.findSalones();
    }

    @GetMapping("/{id}")
    public Salon getSalon(@PathVariable long id) throws Exception {return salonesServices.findSalonById(id);}

    @PutMapping("/update")
    public Salon updateSalon(@RequestBody @Valid Salon salon) throws Exception {
        return salonesServices.updateSalon(salon);
    }
    @PostMapping("/savesalon")
    @ResponseStatus(HttpStatus.CREATED)
    public Salon saveSalon(@RequestBody Salon salon) throws Exception {
        return salonesServices.saveSalon(salon);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSalon(@PathVariable long id) throws Exception {
        salonesServices.deleteById(id);
    }
}
