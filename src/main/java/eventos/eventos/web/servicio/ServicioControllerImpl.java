package eventos.eventos.web.servicio;

import eventos.eventos.model.Servicio;
import eventos.eventos.services.servicio.ServicioService;
import eventos.eventos.web._CRUD.CRUDControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicio")
public class ServicioControllerImpl extends CRUDControllerImpl<Servicio> implements ServicioController {

    public ServicioControllerImpl(ServicioService servicioService) {
        super(servicioService);
    }

}

