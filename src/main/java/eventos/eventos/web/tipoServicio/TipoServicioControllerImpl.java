package eventos.eventos.web.tipoServicio;

import eventos.eventos.model.TipoServicio;
import eventos.eventos.services.tipoServicio.TipoServicioService;
import eventos.eventos.web._CRUD.CRUDControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipoServicio")
public class TipoServicioControllerImpl extends CRUDControllerImpl<TipoServicio> implements TipoServicioController {

    public TipoServicioControllerImpl(TipoServicioService tipoServicioService) {
        super(tipoServicioService);
    }
}

