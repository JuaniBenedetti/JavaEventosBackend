package eventos.eventos.web.reserva;

import eventos.eventos.model.Cliente;
import eventos.eventos.model.Reserva;
import eventos.eventos.security.UserDetailsImpl;
import eventos.eventos.security.UserDetailsServiceImpl;
import eventos.eventos.services.cliente.ClienteService;
import eventos.eventos.services.reserva.ReservaService;
import eventos.eventos.web._CRUD.CRUDControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/reserva")
public class ReservaControllerImpl extends CRUDControllerImpl<Reserva> implements ReservaController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private ClienteService clienteService;

    private final ReservaService reservaService;

    public ReservaControllerImpl(ReservaService reservaService) {
        super(reservaService);
        this.reservaService = reservaService;
    }

    @Override
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva save(@RequestBody @Valid Reserva reserva) throws Exception {
        reserva.setCliente(clienteActual());
        return reservaService.save(reserva);
    }

    @Override
    @GetMapping("/findAllByCliente")
    public Set<Reserva> findAllByCliente() throws Exception {
        Cliente cliente = clienteActual();
        return reservaService.findAllByCliente(cliente);
    }

    private Cliente clienteActual() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl usuarioActual = userDetailsService.loadUserByUsername(authentication.getPrincipal().toString());
        Cliente cliente = clienteService.findByUsuario(usuarioActual.getUsuario());
        return cliente;
    }
}
