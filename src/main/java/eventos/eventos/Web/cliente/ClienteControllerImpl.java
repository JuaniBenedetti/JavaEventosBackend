package eventos.eventos.Web.cliente;


import eventos.eventos.Model.Cliente;
import eventos.eventos.Services.cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteControllerImpl implements ClienteController {

    private final ClienteService clienteService;

    @Override
    @GetMapping("/findClientes")
    public List<Cliente> getClientes() throws Exception {
        return clienteService.findClientes();
    }
    @Override
    @GetMapping("/findCliente/{id}")
    public Cliente getCliente(@PathVariable long id) throws Exception{
        return clienteService.findCliente(id);
    }
    @Override
    @PutMapping("/update")
    public Cliente updateCliente(@RequestBody @Valid Cliente cliente) throws Exception{
        return clienteService.updateCliente(cliente);
    }
    @Override
    @PostMapping
    public Cliente newCliente(@RequestBody @Valid Cliente cliente) throws Exception{
        return clienteService.newCliente(cliente);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteCliente ( @PathVariable long id) throws Exception{
        clienteService.deleteCliente(id);
    }
}
