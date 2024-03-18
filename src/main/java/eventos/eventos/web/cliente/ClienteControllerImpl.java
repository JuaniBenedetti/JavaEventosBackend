package eventos.eventos.web.cliente;

import eventos.eventos.model.Cliente;
import eventos.eventos.services.cliente.ClienteService;
import eventos.eventos.web._CRUD.CRUDControllerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteControllerImpl extends CRUDControllerImpl<Cliente> implements ClienteController {

    public ClienteControllerImpl(ClienteService clienteService) { super(clienteService); }
}
