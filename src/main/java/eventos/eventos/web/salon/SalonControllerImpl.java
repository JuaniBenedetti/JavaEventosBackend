package eventos.eventos.web.salon;

import eventos.eventos.model.Salon;
import eventos.eventos.services.salon.SalonService;
import eventos.eventos.web._CRUD.CRUDControllerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/salon")
public class SalonControllerImpl extends CRUDControllerImpl<Salon> implements SalonController {

    public SalonControllerImpl(SalonService salonService) { super(salonService); }
}

